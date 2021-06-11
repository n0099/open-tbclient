package d.a.n0.e3.h0;

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
    public static final Pattern f57702f = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f57703g = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");

    /* renamed from: c  reason: collision with root package name */
    public String f57706c;

    /* renamed from: a  reason: collision with root package name */
    public int f57704a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f57705b = null;

    /* renamed from: d  reason: collision with root package name */
    public String f57707d = null;

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f57708e = null;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.z0.r {
        public a(Context context) {
            super(context);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c(l.this.f57705b);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.m0.z0.r {
        public b(Context context) {
            super(context);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Matcher matcher = l.f57702f.matcher(l.this.f57707d);
            if (matcher.find()) {
                try {
                    String group = matcher.group();
                    b(group.substring(group.lastIndexOf("/") + 1));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Matcher matcher2 = l.f57703g.matcher(l.this.f57707d);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    b(group2.substring(group2.lastIndexOf("=") + 1));
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            c(l.this.f57707d);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.m0.z0.r {
        public c(Context context) {
            super(context);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (l.this.f57705b != null) {
                l.this.f57705b.replace("@", "").replace(" ", "");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a()).createNormalConfig(d.a.c.e.m.b.f(l.this.f57707d, 0L), false, false)));
        }
    }

    public static boolean l(int i2, int i3) {
        return (i2 != 0 || i3 == 3 || i3 == 2) ? false : true;
    }

    public SpannableStringBuilder e(SpannableString spannableString) {
        if (this.f57708e == null) {
            this.f57708e = new SpannableStringBuilder();
        }
        this.f57708e.append((CharSequence) spannableString);
        return this.f57708e;
    }

    public String f() {
        return this.f57706c;
    }

    public String g() {
        return this.f57707d;
    }

    public SpannableString h(Context context) {
        int i2 = this.f57704a;
        if (i2 != 0) {
            if (i2 == 1) {
                if (!this.f57705b.endsWith(" ")) {
                    this.f57705b += " ";
                }
                SpannableString spannableString = new SpannableString(this.f57705b);
                spannableString.setSpan(new b(context), 0, this.f57705b.length() - 1, 33);
                return spannableString;
            } else if (i2 == 2) {
                SpannableString spannableString2 = new SpannableString(this.f57705b + " ");
                d.a.c.k.d.a face = TbadkCoreApplication.getInst().getFace(this.f57705b);
                if (face != null) {
                    BitmapDrawable j = face.j();
                    j.setBounds(0, 0, face.r(), face.m());
                    spannableString2.setSpan(new ImageSpan(j, 1), 0, this.f57705b.length(), 33);
                }
                return spannableString2;
            } else if (i2 == 4) {
                if (!this.f57705b.endsWith(" ")) {
                    this.f57705b += " ";
                }
                SpannableString spannableString3 = new SpannableString(this.f57705b);
                spannableString3.setSpan(new c(context), 0, this.f57705b.length() - 1, 33);
                return spannableString3;
            } else if (i2 != 5) {
                return null;
            } else {
                if (!this.f57705b.endsWith(" ")) {
                    this.f57705b += " ";
                }
                String string = context.getString(R.string.video);
                String str = string + this.f57705b;
                SpannableString spannableString4 = new SpannableString(str);
                spannableString4.setSpan(new a(context), string.length(), str.length() - 1, 33);
                return spannableString4;
            }
        }
        return new SpannableString(this.f57705b);
    }

    public String i() {
        return this.f57705b;
    }

    public int j() {
        return this.f57704a;
    }

    public SpannableStringBuilder k() {
        return this.f57708e;
    }

    public void m(int i2) {
        this.f57704a = i2;
    }
}
