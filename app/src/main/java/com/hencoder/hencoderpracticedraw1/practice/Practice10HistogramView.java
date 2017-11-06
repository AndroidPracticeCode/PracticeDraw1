package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public List<BarBean> datas = new ArrayList<>();

    {
        datas.add(new BarBean(9, "Froyo"));
        datas.add(new BarBean(20, "GB"));
        datas.add(new BarBean(20, "AAA"));
        datas.add(new BarBean(300, "VB"));
        datas.add(new BarBean(500, "VVV"));
        datas.add(new BarBean(700, "CCC"));
        datas.add(new BarBean(280, "SSS"));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //1.先画白线
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.WHITE);
        Path path = new Path();
        path.moveTo(100, 50);
        path.lineTo(100, 800);
        path.lineTo(1300, 800);
        canvas.drawPath(path, paint);
        //2、画方格
        path.reset();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        float barWidth = 1200 / datas.size();
        for (int i = 0; i < datas.size(); i++) {
            BarBean bean = datas.get(i);
            canvas.drawRect(i * barWidth + 120, 800 - bean.count, (i + 1) * barWidth + 100, 800, paint);
        }
        path.reset();
        //3、画字
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        for (int i = 0; i < datas.size(); i++) {
            BarBean bean = datas.get(i);
            canvas.drawText(bean.name, i * barWidth + 150, 840, paint);
        }
    }

    class BarBean {
        public int count;
        public String name;

        public BarBean(int count, String name) {
            this.count = count;
            this.name = name;
        }
    }
}
