package d.a.i0.a.p.c;

import android.content.Context;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.v2.q0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/* loaded from: classes2.dex */
public class t implements d.a.i0.a.p.d.l0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f43798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f43799f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43800g;

        /* renamed from: d.a.i0.a.p.c.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0776a implements Runnable {

            /* renamed from: d.a.i0.a.p.c.t$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0777a implements Runnable {
                public RunnableC0777a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    d.a.i0.a.v2.i0.a(aVar.f43800g, aVar.f43799f);
                }
            }

            public RunnableC0776a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    PrintWriter printWriter = new PrintWriter(a.this.f43799f);
                    printWriter.println(d.a.i0.a.v2.k.g(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
                    printWriter.println(a.this.f43798e.toString());
                    printWriter.flush();
                    printWriter.close();
                    q0.X(new RunnableC0777a());
                } catch (FileNotFoundException e2) {
                    d.a.i0.a.e0.d.a("DefaultSwanAppLogManager", Log.getStackTraceString(e2));
                    d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), a.this.f43800g.getString(d.a.i0.a.h.swan_app_system_error)).F();
                }
            }
        }

        public a(t tVar, StringBuilder sb, File file, Context context) {
            this.f43798e = sb;
            this.f43799f = file;
            this.f43800g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f43798e.append(str);
            d.a.i0.a.v2.q.j(new RunnableC0776a(), "");
        }
    }

    @Override // d.a.i0.a.p.d.l0
    public void a(Context context) {
        File K2;
        if (context == null || (K2 = d.a.i0.a.h0.g.i.K2()) == null) {
            return;
        }
        if (K2.exists() || K2.mkdirs()) {
            File file = new File(K2, "runninginfo_" + d.a.i0.a.v2.k.g(System.currentTimeMillis(), "yyyyMMdd") + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            StringBuilder sb = new StringBuilder();
            sb.append(d.a.i0.a.v2.p.h(context));
            sb.append("===== 启动信息 =====");
            sb.append("\n");
            d.a.i0.a.v2.p.g(context, new a(this, sb, file, context));
        }
    }
}
