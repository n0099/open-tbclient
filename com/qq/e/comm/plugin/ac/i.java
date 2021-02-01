package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.w;
/* loaded from: classes15.dex */
public class i extends RelativeLayout implements com.qq.e.comm.plugin.a.d.a {

    /* renamed from: a  reason: collision with root package name */
    public h f11858a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f11859b;
    private Context c;
    private com.qq.e.comm.plugin.s.a d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private com.qq.e.comm.plugin.a.d.a k;

    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        com.qq.e.comm.plugin.s.a f11862a;

        /* renamed from: b  reason: collision with root package name */
        int f11863b;
        int c;
        int d;
        int f;
        int g;
        String[] i;
        com.qq.e.comm.plugin.a.d.a j;
        int e = 12;
        int h = -1;

        public a a(int i) {
            this.f11863b = i;
            return this;
        }

        public a a(com.qq.e.comm.plugin.a.d.a aVar) {
            this.j = aVar;
            return this;
        }

        public a a(com.qq.e.comm.plugin.s.a aVar) {
            this.f11862a = aVar;
            return this;
        }

        public a a(String[] strArr) {
            if (strArr == null || strArr.length != 5) {
                ai.a("ProgressButton", "setStatusText null or length is not 5");
            } else {
                this.i = strArr;
            }
            return this;
        }

        public i a(Context context) {
            i iVar = new i(context);
            iVar.a(this);
            return iVar;
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public a c(int i) {
            this.d = i;
            return this;
        }

        public a d(int i) {
            this.e = i;
            return this;
        }

        public a e(int i) {
            this.f = i;
            return this;
        }

        public a f(int i) {
            this.g = i;
            return this;
        }

        public a g(int i) {
            this.h = i;
            return this;
        }
    }

    private i(Context context) {
        super(context);
        this.f = "打开";
        this.g = "下载";
        this.h = "下载中";
        this.i = "安装";
        this.j = "打开";
        this.c = context;
    }

    private String a() {
        return (this.d == null || !this.d.v() || this.d.z() == null) ? "" : this.d.z().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        switch (i) {
            case 0:
            case 16:
            case 32:
            case 64:
                if (this.f11858a != null) {
                    this.f11858a.a(100);
                }
                if (this.f11859b != null) {
                    this.f11859b.setText(this.g);
                    return;
                }
                return;
            case 1:
                if (this.f11858a != null) {
                    this.f11858a.a(100);
                }
                if (this.f11859b != null) {
                    this.f11859b.setText(this.j);
                    return;
                }
                return;
            case 4:
                if (this.f11858a != null) {
                    this.f11858a.a(i2);
                }
                if (this.f11859b != null) {
                    this.f11859b.setText(this.h);
                    this.f11859b.setTextColor(this.e);
                    return;
                }
                return;
            case 8:
                if (this.f11858a != null) {
                    this.f11858a.a(100);
                }
                if (this.f11859b != null) {
                    this.f11859b.setText(this.i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f11858a = new h(this.c);
        this.f11859b = new TextView(this.c);
        this.d = aVar.f11862a;
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            l.a().a(a2, this);
        }
        this.e = aVar.g;
        this.k = aVar.j;
        if (aVar.i != null && aVar.i.length == 5) {
            this.f = aVar.i[0];
            this.g = aVar.i[1];
            this.h = aVar.i[2];
            this.i = aVar.i[3];
            this.j = aVar.i[4];
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar.c, aVar.d);
        this.f11858a.setLayoutParams(layoutParams);
        if (aVar.h != -1) {
            this.f11858a.c(aVar.h);
        }
        this.f11858a.a(aVar.f11863b);
        this.f11858a.b(100);
        this.f11858a.a(true);
        this.f11859b.setLayoutParams(layoutParams);
        this.f11859b.setBackgroundDrawable(null);
        this.f11859b.setGravity(17);
        this.f11859b.setTextColor(aVar.f);
        this.f11859b.setTextSize(2, aVar.e);
        if (this.d == null || !this.d.v()) {
            this.f11859b.setText(this.f);
        } else {
            a(l.a().a(a2), -1);
        }
        addView(this.f11858a);
        addView(this.f11859b);
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(final String str, final int i, final int i2, final long j) {
        String a2 = a();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(str)) {
            ai.a("ProgressButton", "onAPKStatusUpdate adInfoPkgName or pkgName null");
        } else if (a2.equals(str)) {
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.ac.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.a(i, i2);
                    if (i.this.k != null) {
                        i.this.k.a(str, i, i2, j);
                    }
                }
            });
        } else {
            ai.a("ProgressButton", "onAPKStatusUpdate adInfoPkgName mismatch pkgName");
        }
    }
}
