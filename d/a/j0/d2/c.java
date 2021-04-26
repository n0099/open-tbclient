package d.a.j0.d2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tieba.R;
import d.a.i0.r.f0.l;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f51901a;

    public static String a() {
        if (TextUtils.isEmpty(f51901a)) {
            f51901a = d.a.i0.r.d0.b.j().p("nick_name_activity_link", "");
        }
        return f51901a;
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
