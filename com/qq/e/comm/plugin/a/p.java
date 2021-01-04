package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.e;
import com.qq.e.comm.plugin.a.f;
import com.qq.e.comm.plugin.a.g;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class p implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11938a;

    /* renamed from: b  reason: collision with root package name */
    private final c f11939b;
    private f.a c;
    private f.a d;

    /* loaded from: classes3.dex */
    public static final class a implements e.b, g.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f11941a = new a();

        /* renamed from: b  reason: collision with root package name */
        private ConcurrentHashMap<String, f.a> f11942b = new ConcurrentHashMap<>();
        private e c;

        private a() {
            new g(this).a(GDTADManager.getInstance().getAppContext());
            this.c = new e(this);
        }

        public void a(f.a aVar, c cVar) {
            if (aVar == null || cVar == null) {
                return;
            }
            a(aVar, cVar.h());
        }

        public void a(f.a aVar, String str) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11942b.put(str, aVar);
            this.c.a(str);
        }

        @Override // com.qq.e.comm.plugin.a.e.b
        public void a(String str) {
            c(str);
        }

        @Override // com.qq.e.comm.plugin.a.e.b
        public boolean b(String str) {
            return this.f11942b.containsKey(str);
        }

        @Override // com.qq.e.comm.plugin.a.g.a
        public void c(String str) {
            f.a remove;
            if (str == null || !this.f11942b.containsKey(str) || (remove = this.f11942b.remove(str)) == null) {
                return;
            }
            remove.a(0, "", remove.a());
        }
    }

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, c cVar) {
        this.d = new f.a() { // from class: com.qq.e.comm.plugin.a.p.1
            @Override // com.qq.e.comm.plugin.a.f.a
            public void a(int i, String str, boolean z) {
                if (i == 0) {
                    p.this.a(p.this.f11939b);
                }
                if (p.this.c != null) {
                    p.this.c.a(i, str, z);
                }
            }

            @Override // com.qq.e.comm.plugin.a.f.a
            public boolean a() {
                return false;
            }
        };
        this.f11938a = context.getApplicationContext();
        this.f11939b = cVar;
    }

    private Intent a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri a2 = com.qq.e.comm.plugin.d.c.a(context, file);
        intent.addFlags(1);
        intent.setDataAndType(a2, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Context appContext;
        Intent a2;
        if (cVar == null || (a2 = n.a((appContext = GDTADManager.getInstance().getAppContext()), cVar)) == null) {
            return;
        }
        com.qq.e.comm.plugin.a.b.a aVar = new com.qq.e.comm.plugin.a.b.a(appContext, cVar);
        aVar.a(new com.qq.e.comm.plugin.a.b.b(a2, cVar, appContext));
        aVar.c();
        com.qq.e.comm.plugin.a.d.b.a().b(cVar.h());
    }

    @Override // com.qq.e.comm.plugin.a.f
    public void a(f.a aVar) {
        this.c = aVar;
    }

    @Override // com.qq.e.comm.plugin.a.f
    public void a(File file) {
        if (b(file)) {
            a.f11941a.a(this.d, this.f11939b);
        } else if (this.c != null) {
            this.c.a(1, "", false);
        }
    }

    public boolean b(File file) {
        Intent a2 = a(this.f11938a, file);
        if (this.f11938a.getPackageManager().resolveActivity(a2, 0) != null) {
            this.f11938a.startActivity(a2);
            return true;
        }
        return false;
    }
}
