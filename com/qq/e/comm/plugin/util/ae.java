package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    private OrientationEventListener f12851a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12852b;
    private boolean c;
    private boolean d;
    private int e;
    private int f = 1;
    private WeakReference<Activity> g;
    private boolean h;
    private a i;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public ae(Activity activity) {
        this.g = new WeakReference<>(activity);
        a(activity.getApplicationContext());
    }

    private void a(final Context context) {
        if (this.f12851a == null) {
            this.f12851a = new OrientationEventListener(context) { // from class: com.qq.e.comm.plugin.util.ae.1
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    if (Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                        if ((i >= 0 && i <= 30) || i >= 330) {
                            if (ae.this.f12852b) {
                                if (ae.this.e <= 0 || ae.this.c) {
                                    ae.this.d = true;
                                    ae.this.f12852b = false;
                                    ae.this.e = 0;
                                }
                            } else if (ae.this.e > 0) {
                                ae.this.f = 1;
                                if (ae.this.i != null) {
                                    ae.this.i.a();
                                }
                                if (ae.this.g == null || ae.this.g.get() == null) {
                                    return;
                                }
                                ((Activity) ae.this.g.get()).setRequestedOrientation(1);
                                ae.this.e = 0;
                                ae.this.f12852b = false;
                            }
                        } else if (i >= 240 && i <= 300) {
                            if (ae.this.f12852b) {
                                if (ae.this.e == 1 || ae.this.d) {
                                    ae.this.c = true;
                                    ae.this.f12852b = false;
                                    ae.this.e = 1;
                                }
                            } else if (ae.this.e != 1) {
                                ae.this.f = 0;
                                if (ae.this.i != null) {
                                    ae.this.i.b();
                                }
                                if (ae.this.g == null || ae.this.g.get() == null) {
                                    return;
                                }
                                ((Activity) ae.this.g.get()).setRequestedOrientation(0);
                                ae.this.e = 1;
                                ae.this.f12852b = false;
                            }
                        } else if (i <= 60 || i >= 120) {
                        } else {
                            if (ae.this.f12852b) {
                                if (ae.this.e == 2 || ae.this.d) {
                                    ae.this.c = true;
                                    ae.this.f12852b = false;
                                    ae.this.e = 2;
                                }
                            } else if (ae.this.e != 2) {
                                ae.this.f = 0;
                                if (ae.this.i != null) {
                                    ae.this.i.c();
                                }
                                if (ae.this.g == null || ae.this.g.get() == null) {
                                    return;
                                }
                                ((Activity) ae.this.g.get()).setRequestedOrientation(8);
                                ae.this.e = 2;
                                ae.this.f12852b = false;
                            }
                        }
                    }
                }
            };
        }
    }

    public void a() {
        if (this.f12851a != null) {
            this.f12851a.disable();
            this.g = null;
        }
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(boolean z) {
        this.h = z;
        if (this.h) {
            this.f12851a.enable();
        } else {
            this.f12851a.disable();
        }
    }

    public void b() {
        if (this.g == null) {
            GDTLogger.e("orientationutil has been released");
            return;
        }
        this.f12852b = true;
        if (this.e == 0) {
            this.f = 0;
            if (this.g == null || this.g.get() == null) {
                return;
            }
            this.g.get().setRequestedOrientation(0);
            if (this.i != null) {
                this.i.b();
            }
            this.e = 1;
            this.c = false;
            return;
        }
        this.f = 1;
        if (this.g == null || this.g.get() == null) {
            return;
        }
        this.g.get().setRequestedOrientation(1);
        if (this.i != null) {
            this.i.a();
        }
        this.e = 0;
        this.d = false;
    }
}
