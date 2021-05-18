package d.a.k0.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m {
    public static void a(String str) {
        d.a.k0.d3.n0.d readThreadHistory;
        if (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || readThreadHistory.b(str)) {
            return;
        }
        readThreadHistory.a(str);
    }

    public static void b(a2 a2Var, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder == null || d.a.c.e.p.k.isEmptyStringAfterTrim(spannableStringBuilder.toString()) || a2Var == null || a2Var.x0() != 0) {
            return;
        }
        if (z || a2Var.v0() == 1 || StringUtils.isNull(a2Var.y1())) {
            ArrayList<d.a.j0.b1.m.b> Q0 = a2Var.Q0();
            if (ListUtils.isEmpty(Q0)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < Q0.size(); i2++) {
                if (Q0.get(i2) != null && !StringUtils.isNull(Q0.get(i2).a())) {
                    sb.append(Q0.get(i2).a());
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            int i3 = 0;
            for (int i4 = 0; i4 < Q0.size(); i4++) {
                if (Q0.get(i4) != null && !StringUtils.isNull(Q0.get(i4).a())) {
                    int length = Q0.get(i4).a().length();
                    c(spannableString, Q0.get(i4), i3, length);
                    i3 += length;
                }
            }
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
        }
    }

    public static void c(SpannableString spannableString, d.a.j0.b1.m.b bVar, int i2, int i3) {
        int i4;
        if (spannableString == null || bVar == null || (i4 = i3 + i2) > spannableString.length()) {
            return;
        }
        spannableString.setSpan(new d.a.j0.b1.m.c(bVar), i2, i4, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(bVar.f49085i), i2, i4, 33);
    }

    public static SpannableStringBuilder d(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static String e() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String f() {
        return "frs_page";
    }

    public static String g() {
        return "personalize_page";
    }

    public static SpannableStringBuilder h(Context context, String str, ArrayList<a> arrayList, boolean z) {
        return i(context, str, arrayList, z, true);
    }

    public static SpannableStringBuilder i(Context context, String str, ArrayList<a> arrayList, boolean z, boolean z2) {
        if (str == null || context == null || arrayList == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i2 = 0; i2 != arrayList.size(); i2++) {
            a aVar = arrayList.get(i2);
            if (aVar != null) {
                int i3 = aVar.f63249a;
                if (i3 > 0) {
                    aVar.f63250b = context.getString(i3);
                }
                if (!d.a.c.e.p.k.isEmpty(aVar.f63250b)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.f63250b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(aVar.f63251c)), length, spannableStringBuilder.length(), 17);
                    if (i2 == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = SkinManager.getBitmap(aVar.f63252d);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    d.a.j0.r.f0.i iVar = new d.a.j0.r.f0.i(bitmapDrawable);
                    int i4 = aVar.f63253e;
                    if (i4 != 0) {
                        iVar.b(i4);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(iVar, length2, spannableStringBuilder.length(), 17);
                } else {
                    continue;
                }
            }
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    public static void j(a2 a2Var, TextView textView) {
        if ((StringUtils.isNull(a2Var.y1()) && (a2Var.b1() == null || a2Var.b1().size() == 0)) || a2Var.v0() == 1) {
            a2Var.U2(false, true);
            if (a2Var.l1() != null && !StringUtils.isNull(a2Var.l1().toString())) {
                textView.setVisibility(0);
                textView.setText(a2Var.l1());
                return;
            }
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        a2Var.p = 0;
        a2Var.U2(false, true);
        SpannableStringBuilder l1 = a2Var.l1();
        textView.setOnTouchListener(new d.a.k0.u3.i(l1));
        textView.setText(l1);
        l(textView, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public static boolean k(String str) {
        d.a.k0.d3.n0.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.d(str)) ? false : true;
    }

    public static void l(TextView textView, String str, int i2, int i3) {
        if (textView instanceof TextView) {
            if (k(str) && TbSingleton.getInstance().isInFrs) {
                SkinManager.setViewTextColor(textView, i3);
            } else {
                SkinManager.setViewTextColor(textView, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f63249a;

        /* renamed from: b  reason: collision with root package name */
        public String f63250b;

        /* renamed from: c  reason: collision with root package name */
        public int f63251c;

        /* renamed from: d  reason: collision with root package name */
        public int f63252d;

        /* renamed from: e  reason: collision with root package name */
        public int f63253e;

        public a(int i2, int i3, int i4) {
            this.f63249a = -1;
            this.f63250b = "";
            this.f63251c = R.color.CAM_X0304;
            this.f63252d = R.drawable.pic_dot_title;
            this.f63253e = 0;
            this.f63249a = i2;
            this.f63251c = i3;
            this.f63252d = i4;
        }

        public a(int i2) {
            this.f63249a = -1;
            this.f63250b = "";
            this.f63251c = R.color.CAM_X0304;
            this.f63252d = R.drawable.pic_dot_title;
            this.f63253e = 0;
            this.f63249a = i2;
        }

        public a(String str) {
            this.f63249a = -1;
            this.f63250b = "";
            this.f63251c = R.color.CAM_X0304;
            this.f63252d = R.drawable.pic_dot_title;
            this.f63253e = 0;
            this.f63250b = str;
        }

        public a(String str, int i2) {
            this.f63249a = -1;
            this.f63250b = "";
            this.f63251c = R.color.CAM_X0304;
            this.f63252d = R.drawable.pic_dot_title;
            this.f63253e = 0;
            this.f63250b = str;
            this.f63252d = i2;
        }
    }
}
