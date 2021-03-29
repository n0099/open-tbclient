package d.b.i0.t1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f61082a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61083b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f61084c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f61085d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f61086e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61087f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f61088g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f61089h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f61086e != null) {
                ((WindowManager) c.this.f61083b.getSystemService("window")).removeViewImmediate(c.this.f61086e);
                c.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.k(cVar.f61083b.getString(R.string.data_init));
        }
    }

    /* renamed from: d.b.i0.t1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1586c {
        c getSplash();
    }

    /* loaded from: classes3.dex */
    public class d extends TextView {

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f61092e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f61093f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f61094g;

        /* renamed from: h  reason: collision with root package name */
        public int f61095h;
        public int i;
        public boolean j;

        public d(c cVar, Context context) {
            super(context);
            this.f61095h = 0;
            this.i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.j || this.f61093f == null) {
                return;
            }
            int i = this.i;
            int i2 = this.f61095h;
            int i3 = i + (i2 / 10);
            this.i = i3;
            if (i3 > i2 * 2) {
                this.i = -i2;
            }
            this.f61093f.setTranslate(this.i, 0.0f);
            this.f61092e.setLocalMatrix(this.f61093f);
            postInvalidateDelayed(50L);
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.f61095h == 0) {
                int measuredWidth = getMeasuredWidth();
                this.f61095h = measuredWidth;
                if (measuredWidth > 0) {
                    this.f61094g = getPaint();
                    LinearGradient linearGradient = new LinearGradient(-this.f61095h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.f61092e = linearGradient;
                    this.f61094g.setShader(linearGradient);
                    this.f61093f = new Matrix();
                }
            }
        }
    }

    public c(Context context) {
        this.f61083b = context;
    }

    public final void e() {
        Handler handler = this.f61085d;
        if (handler != null) {
            handler.removeCallbacks(this.f61088g);
            this.f61085d.removeCallbacks(this.f61089h);
            this.f61089h = null;
            this.f61088g = null;
            this.f61085d = null;
        }
        HandlerThread handlerThread = this.f61084c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.f61087f != null) {
            this.f61087f = null;
        }
        if (this.f61086e != null) {
            this.f61086e = null;
        }
        this.f61082a = false;
    }

    public final List<String> f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("com.baidu.tieba.SPLASH_PIPELINE_ACTION");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        ArrayList arrayList = new ArrayList();
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.name;
                arrayList.add(StringUtil.ARRAY_START + packageName + "/" + str + "}");
            }
        }
        return arrayList;
    }

    public void g() {
        if (this.f61086e == null || this.f61087f == null) {
            return;
        }
        this.f61085d.removeCallbacks(this.f61088g);
        this.f61085d.post(this.f61088g);
    }

    public final boolean h() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.f61083b.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.f61083b.getPackageName();
        int myPid = Process.myPid();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            if (runningAppProcesses.get(i).pid == myPid && TextUtils.equals(runningAppProcesses.get(i).processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i() {
        List<String> f2 = f(this.f61083b);
        if (f2 != null && f2.size() != 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f61083b.getSystemService("activity")).getRunningTasks(1).get(0);
            String shortString = runningTaskInfo.baseActivity.toShortString();
            String shortString2 = runningTaskInfo.topActivity.toShortString();
            for (String str : f2) {
                if (shortString.equals(str) || shortString2.equals(str)) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
        }
        return false;
    }

    public void j() {
        if (!this.f61082a && h() && i()) {
            if (this.f61084c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f61084c = handlerThread;
                handlerThread.start();
            }
            if (this.f61085d == null) {
                this.f61085d = new Handler(this.f61084c.getLooper());
            }
            if (this.f61088g == null) {
                this.f61088g = new a();
            }
            if (this.f61089h == null) {
                this.f61089h = new b();
            }
            this.f61085d.removeCallbacks(this.f61089h);
            this.f61085d.postAtFrontOfQueue(this.f61089h);
            this.f61082a = true;
            this.f61085d.postDelayed(this.f61088g, 20000L);
        }
    }

    public final void k(String str) {
        if (this.f61087f == null) {
            d dVar = new d(this, this.f61083b);
            this.f61087f = dVar;
            dVar.setTextSize(1, 18.0f);
        }
        this.f61087f.setText(str);
        RelativeLayout relativeLayout = new RelativeLayout(this.f61083b);
        this.f61086e = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f61086e.addView(this.f61087f, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.f61083b.getSystemService("window")).addView(this.f61086e, layoutParams2);
    }
}
