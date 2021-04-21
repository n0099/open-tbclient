package d.b.j0.d3.h0;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f55256f = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f55257g = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");

    /* renamed from: c  reason: collision with root package name */
    public String f55260c;

    /* renamed from: a  reason: collision with root package name */
    public int f55258a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f55259b = null;

    /* renamed from: d  reason: collision with root package name */
    public String f55261d = null;

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f55262e = null;

    /* loaded from: classes5.dex */
    public class a extends d.b.i0.z0.r {
        public a(Context context) {
            super(context);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c(l.this.f55259b);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.i0.z0.r {
        public b(Context context) {
            super(context);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Matcher matcher = l.f55256f.matcher(l.this.f55261d);
            if (matcher.find()) {
                try {
                    String group = matcher.group();
                    b(group.substring(group.lastIndexOf("/") + 1));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Matcher matcher2 = l.f55257g.matcher(l.this.f55261d);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    b(group2.substring(group2.lastIndexOf("=") + 1));
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            c(l.this.f55261d);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.b.i0.z0.r {
        public c(Context context) {
            super(context);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (l.this.f55259b != null) {
                l.this.f55259b.replace("@", "").replace(" ", "");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a()).createNormalConfig(d.b.c.e.m.b.f(l.this.f55261d, 0L), false, false)));
        }
    }

    public static boolean l(int i, int i2) {
        return (i != 0 || i2 == 3 || i2 == 2) ? false : true;
    }

    public SpannableStringBuilder e(SpannableString spannableString) {
        if (this.f55262e == null) {
            this.f55262e = new SpannableStringBuilder();
        }
        this.f55262e.append((CharSequence) spannableString);
        return this.f55262e;
    }

    public String f() {
        return this.f55260c;
    }

    public String g() {
        return this.f55261d;
    }

    public SpannableString h(Context context) {
        int i = this.f55258a;
        if (i != 0) {
            if (i == 1) {
                if (!this.f55259b.endsWith(" ")) {
                    this.f55259b += " ";
                }
                SpannableString spannableString = new SpannableString(this.f55259b);
                spannableString.setSpan(new b(context), 0, this.f55259b.length() - 1, 33);
                return spannableString;
            } else if (i == 2) {
                SpannableString spannableString2 = new SpannableString(this.f55259b + " ");
                d.b.c.j.d.a face = TbadkCoreApplication.getInst().getFace(this.f55259b);
                if (face != null) {
                    BitmapDrawable j = face.j();
                    j.setBounds(0, 0, face.r(), face.m());
                    spannableString2.setSpan(new ImageSpan(j, 1), 0, this.f55259b.length(), 33);
                }
                return spannableString2;
            } else if (i == 4) {
                if (!this.f55259b.endsWith(" ")) {
                    this.f55259b += " ";
                }
                SpannableString spannableString3 = new SpannableString(this.f55259b);
                spannableString3.setSpan(new c(context), 0, this.f55259b.length() - 1, 33);
                return spannableString3;
            } else if (i != 5) {
                return null;
            } else {
                if (!this.f55259b.endsWith(" ")) {
                    this.f55259b += " ";
                }
                String string = context.getString(R.string.video);
                String str = string + this.f55259b;
                SpannableString spannableString4 = new SpannableString(str);
                spannableString4.setSpan(new a(context), string.length(), str.length() - 1, 33);
                return spannableString4;
            }
        }
        return new SpannableString(this.f55259b);
    }

    public String i() {
        return this.f55259b;
    }

    public int j() {
        return this.f55258a;
    }

    public SpannableStringBuilder k() {
        return this.f55262e;
    }

    public void m(int i) {
        this.f55258a = i;
    }
}
