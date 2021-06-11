package d.a.n0.r0.q1.e;

import android.graphics.drawable.ShapeDrawable;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.n0.r0.q1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1593a extends ShapeDrawable {

        /* renamed from: a  reason: collision with root package name */
        public int f63123a;

        /* renamed from: b  reason: collision with root package name */
        public int f63124b;

        public C1593a(int i2, int i3, int i4, int i5) {
            this.f63123a = i4;
            this.f63124b = i5;
            setDither(false);
            getPaint().setColor(i2);
            setIntrinsicWidth(i3);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i2, int i3, int i4, int i5) {
            super.setBounds(i2, i3 + this.f63123a, i4, i5 + this.f63124b);
        }
    }

    public static long a(String str) {
        if (StringUtils.isNull(str)) {
            return 0L;
        }
        try {
            Date parse = new SimpleDateFormat("yyyy.MM.dd").parse(str);
            return (parse != null ? parse.getTime() : 0L) / 1000;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static int b(long j) {
        if (j < 0) {
            return -1;
        }
        return (int) (j / 86400);
    }

    public static void c(int i2, int i3, EditText editText) {
        try {
            Method declaredMethod = TextView.class.getDeclaredMethod("createEditorIfNeeded", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(editText, new Object[0]);
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            Field declaredField2 = Class.forName("android.widget.Editor").getDeclaredField("mCursorDrawable");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(declaredField.get(editText));
            Array.set(obj, 0, new C1593a(SkinManager.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i2, i3));
            Array.set(obj, 1, new C1593a(SkinManager.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i2, i3));
        } catch (Exception unused) {
        }
    }

    public static String d(int i2) {
        switch (i2) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            case 11:
                return "十一";
            case 12:
                return "十二";
            case 13:
                return "十三";
            case 14:
                return "十四";
            case 15:
                return "十五";
            case 16:
                return "十六";
            case 17:
                return "十七";
            case 18:
                return "十八";
            case 19:
                return "十九";
            case 20:
                return "二十";
            default:
                return "";
        }
    }
}
