package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private List<PieBean> datas = new ArrayList<>();

    {
        datas.add(new PieBean(10, "SDSA", Color.DKGRAY));
        datas.add(new PieBean(10, "AAWEA", Color.GRAY));
        datas.add(new PieBean(60, "DDSDS", Color.GREEN));
        datas.add(new PieBean(110, "CCCC", Color.BLUE));
        datas.add(new PieBean(110, "VVV", Color.RED));
        datas.add(new PieBean(60, "AAA", Color.YELLOW));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        //1、画饼
        Paint paint = new Paint();
        int angle = 0;
        for (int i = 0; i < datas.size(); i++) {
            PieBean bean = datas.get(i);
            angle = bean.count;
            paint.setColor(bean.color);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                canvas.drawArc(250, 50, 1050, 850, angle, angle + bean.count, true, paint);
            }
        }
    }

    class PieBean {
        public int count;
        public String text;
        public int color;

        public PieBean(int count, String text, int color) {
            this.count = count;
            this.text = text;
            this.color = color;
        }
    }
}
