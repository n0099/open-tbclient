package d.b.i0.c2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tieba.R;
import d.b.h0.r.f0.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f52310a;

    public static String a() {
        if (TextUtils.isEmpty(f52310a)) {
            f52310a = d.b.h0.r.d0.b.i().o("nick_name_activity_link", "");
        }
        return f52310a;
    }

    public static SpannableStringBuilder b(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(R.drawable.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) "tag");
        spannableStringBuilder.setSpan(new l(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}
