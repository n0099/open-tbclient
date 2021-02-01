package com.qq.e.comm.plugin.w.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f12651a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12652b = false;
    private static Map<String, Future<JSONObject>> c = new LinkedHashMap();

    /* renamed from: com.qq.e.comm.plugin.w.a.f$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass1 implements Callable<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.a f12653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d.b f12654b;
        final /* synthetic */ d.e c;

        AnonymousClass1(d.a aVar, d.b bVar, d.e eVar) {
            this.f12653a = aVar;
            this.f12654b = bVar;
            this.c = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public JSONObject call() throws Exception {
            return f.a(this.f12653a, this.f12654b, this.c);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.f$2  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass2 implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f12655a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f12656b;
        final /* synthetic */ int c;

        AnonymousClass2(Object obj, Context context, int i) {
            this.f12655a = obj;
            this.f12656b = context;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return f.a(this.f12655a, this.f12656b, this.c);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.f$3  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass3 implements Callable<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.a f12657a;

        AnonymousClass3(d.a aVar) {
            this.f12657a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public JSONObject call() throws Exception {
            return com.qq.e.comm.plugin.w.c.a(this.f12657a.f12641a, 4000L);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.f$4  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass4 implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Exchanger f12658a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f12659b;

        AnonymousClass4(Exchanger exchanger, Object obj) {
            this.f12658a = exchanger;
            this.f12659b = obj;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            f.a(this.f12658a);
            d.b(this.f12659b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.f$5  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass5 implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Exchanger f12660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f12661b;

        AnonymousClass5(Exchanger exchanger, Object obj) {
            this.f12660a = exchanger;
            this.f12661b = obj;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            f.b(this.f12660a);
            d.b(this.f12661b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.f$6  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass6 implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Exchanger f12662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f12663b;

        AnonymousClass6(Exchanger exchanger, Object obj) {
            this.f12662a = exchanger;
            this.f12663b = obj;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            f.b(this.f12662a);
            d.b(this.f12663b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.f$7  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass7 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog.Builder f12664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f12665b;
        final /* synthetic */ Exchanger c;

        AnonymousClass7(AlertDialog.Builder builder, Object obj, Exchanger exchanger) {
            this.f12664a = builder;
            this.f12665b = obj;
            this.c = exchanger;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f12664a.show();
                if (this.f12665b instanceof com.qq.e.comm.plugin.ab.h) {
                    ((com.qq.e.comm.plugin.ab.h) this.f12665b).a(new com.qq.e.comm.plugin.ab.a.a(com.qq.e.comm.plugin.ab.a.c.ADOpenOverlay, null));
                }
                d.a(this.f12665b);
            } catch (Throwable th) {
                GDTLogger.report("ExceptionIn DownClickRunnable.confirmDownload", th);
                try {
                    this.c.exchange(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.f$8  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass8 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog.Builder f12666a;

        AnonymousClass8(AlertDialog.Builder builder) {
            this.f12666a = builder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f12666a.show();
            } catch (Throwable th) {
                GDTLogger.report("ExceptionIn DownClickRunnable.confirmDownload", th);
            }
        }
    }

    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ExecutorService f12667a = Executors.newCachedThreadPool();
    }

    private static int a(Context context, String str, String str2, String str3, String str4, boolean z) {
        return gdtadv.getIresult(17, 1, context, str, str2, str3, str4, Boolean.valueOf(z));
    }

    private static com.qq.e.comm.plugin.a.c a(d.a aVar, d.e eVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        return (com.qq.e.comm.plugin.a.c) gdtadv.getobjresult(18, 1, aVar, eVar, jSONObject, jSONObject2, Boolean.valueOf(z));
    }

    static /* synthetic */ Boolean a(Object obj, Context context, int i) {
        return (Boolean) gdtadv.getobjresult(19, 1, obj, context, Integer.valueOf(i));
    }

    private static String a(int i) {
        return (String) gdtadv.getobjresult(20, 1, Integer.valueOf(i));
    }

    private static String a(Future<JSONObject> future) {
        return (String) gdtadv.getobjresult(21, 1, future);
    }

    static /* synthetic */ JSONObject a(d.a aVar, d.b bVar, d.e eVar) {
        return (JSONObject) gdtadv.getobjresult(22, 1, aVar, bVar, eVar);
    }

    public static void a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        gdtadv.getVresult(23, 1, context, onClickListener, onClickListener2);
    }

    static void a(Context context, d.a aVar, Future<JSONObject> future, String str) {
        gdtadv.getVresult(24, 1, context, aVar, future, str);
    }

    public static void a(d.a aVar) {
        gdtadv.getVresult(25, 1, aVar);
    }

    private static void a(d.a aVar, Future<JSONObject> future) {
        gdtadv.getVresult(26, 1, aVar, future);
    }

    static /* synthetic */ void a(Exchanger exchanger) {
        gdtadv.getVresult(27, 1, exchanger);
    }

    private static boolean a(Context context, d.a aVar, Future<JSONObject> future, boolean z) {
        return gdtadv.getZresult(28, 1, context, aVar, future, Boolean.valueOf(z));
    }

    static <T> boolean a(Context context, T t, d.a aVar, d.b bVar, d.e eVar) {
        return gdtadv.getZresult(29, 1, context, t, aVar, bVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(T t, Context context, d.a aVar, d.b bVar, d.e eVar) {
        return gdtadv.getZresult(30, 1, t, context, aVar, bVar, eVar);
    }

    private static <T> boolean a(T t, Context context, d.a aVar, d.b bVar, d.e eVar, int i, Future<JSONObject> future) {
        return gdtadv.getZresult(31, 1, t, context, aVar, bVar, eVar, Integer.valueOf(i), future);
    }

    private static boolean a(JSONObject jSONObject, String str, d.e eVar) {
        return gdtadv.getZresult(32, 1, jSONObject, str, eVar);
    }

    private static <T> Boolean b(T t, Context context, int i) {
        return (Boolean) gdtadv.getobjresult(33, 1, t, context, Integer.valueOf(i));
    }

    private static Future<JSONObject> b(d.a aVar) {
        return (Future) gdtadv.getobjresult(34, 1, aVar);
    }

    private static JSONObject b(d.a aVar, d.b bVar, d.e eVar) {
        return (JSONObject) gdtadv.getobjresult(35, 1, aVar, bVar, eVar);
    }

    static /* synthetic */ void b(Exchanger exchanger) {
        gdtadv.getVresult(36, 1, exchanger);
    }

    static <T> boolean b(T t, Context context, d.a aVar, d.b bVar, d.e eVar) {
        return gdtadv.getZresult(37, 1, t, context, aVar, bVar, eVar);
    }

    private static Future<JSONObject> c(d.a aVar, d.b bVar, d.e eVar) {
        return (Future) gdtadv.getobjresult(38, 1, aVar, bVar, eVar);
    }

    private static void c(Exchanger<Boolean> exchanger) {
        gdtadv.getVresult(39, 1, exchanger);
    }

    private static void d(Exchanger<Boolean> exchanger) {
        gdtadv.getVresult(40, 1, exchanger);
    }
}
