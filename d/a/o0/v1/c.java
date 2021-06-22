package d.a.o0.v1;

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
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f66130a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66131b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f66132c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f66133d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f66134e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66135f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f66136g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f66137h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f66134e != null) {
                ((WindowManager) c.this.f66131b.getSystemService("window")).removeViewImmediate(c.this.f66134e);
                c.this.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.k(cVar.f66131b.getString(R.string.data_init));
        }
    }

    /* renamed from: d.a.o0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1748c {
        c getSplash();
    }

    /* loaded from: classes4.dex */
    public class d extends TextView {

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f66140e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f66141f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f66142g;

        /* renamed from: h  reason: collision with root package name */
        public int f66143h;

        /* renamed from: i  reason: collision with root package name */
        public int f66144i;
        public boolean j;

        public d(c cVar, Context context) {
            super(context);
            this.f66143h = 0;
            this.f66144i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.j || this.f66141f == null) {
                return;
            }
            int i2 = this.f66144i;
            int i3 = this.f66143h;
            int i4 = i2 + (i3 / 10);
            this.f66144i = i4;
            if (i4 > i3 * 2) {
                this.f66144i = -i3;
            }
            this.f66141f.setTranslate(this.f66144i, 0.0f);
            this.f66140e.setLocalMatrix(this.f66141f);
            postInvalidateDelayed(50L);
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (this.f66143h == 0) {
                int measuredWidth = getMeasuredWidth();
                this.f66143h = measuredWidth;
                if (measuredWidth > 0) {
                    this.f66142g = getPaint();
                    LinearGradient linearGradient = new LinearGradient(-this.f66143h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.f66140e = linearGradient;
                    this.f66142g.setShader(linearGradient);
                    this.f66141f = new Matrix();
                }
            }
        }
    }

    public c(Context context) {
        this.f66131b = context;
    }

    public final void e() {
        Handler handler = this.f66133d;
        if (handler != null) {
            handler.removeCallbacks(this.f66136g);
            this.f66133d.removeCallbacks(this.f66137h);
            this.f66137h = null;
            this.f66136g = null;
            this.f66133d = null;
        }
        HandlerThread handlerThread = this.f66132c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.f66135f != null) {
            this.f66135f = null;
        }
        if (this.f66134e != null) {
            this.f66134e = null;
        }
        this.f66130a = false;
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
        if (this.f66134e == null || this.f66135f == null) {
            return;
        }
        this.f66133d.removeCallbacks(this.f66136g);
        this.f66133d.post(this.f66136g);
    }

    public final boolean h() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.f66131b.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.f66131b.getPackageName();
        int myPid = Process.myPid();
        for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
            if (runningAppProcesses.get(i2).pid == myPid && TextUtils.equals(runningAppProcesses.get(i2).processName, packageName)) {
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
        List<String> f2 = f(this.f66131b);
        if (f2 != null && f2.size() != 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f66131b.getSystemService("activity")).getRunningTasks(1).get(0);
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
        if (!this.f66130a && h() && i()) {
            if (this.f66132c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f66132c = handlerThread;
                handlerThread.start();
            }
            if (this.f66133d == null) {
                this.f66133d = new Handler(this.f66132c.getLooper());
            }
            if (this.f66136g == null) {
                this.f66136g = new a();
            }
            if (this.f66137h == null) {
                this.f66137h = new b();
            }
            this.f66133d.removeCallbacks(this.f66137h);
            this.f66133d.postAtFrontOfQueue(this.f66137h);
            this.f66130a = true;
            this.f66133d.postDelayed(this.f66136g, 20000L);
        }
    }

    public final void k(String str) {
        if (this.f66135f == null) {
            d dVar = new d(this, this.f66131b);
            this.f66135f = dVar;
            dVar.setTextSize(1, 18.0f);
        }
        this.f66135f.setText(str);
        RelativeLayout relativeLayout = new RelativeLayout(this.f66131b);
        this.f66134e = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f66134e.addView(this.f66135f, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.f66131b.getSystemService("window")).addView(this.f66134e, layoutParams2);
    }
}
