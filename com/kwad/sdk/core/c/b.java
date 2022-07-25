package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bj;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class b implements c {
    public static volatile b XG;
    public static final List<c> mListeners = new CopyOnWriteArrayList();
    public final AtomicBoolean EL = new AtomicBoolean(false);
    @Nullable
    public Application mApplication;

    public static void a(c cVar) {
        mListeners.add(cVar);
    }

    public static <T> void a(com.kwad.sdk.d.a<c> aVar) {
        for (c cVar : mListeners) {
            if (cVar != null) {
                aVar.accept(cVar);
            }
        }
    }

    public static void b(c cVar) {
        mListeners.remove(cVar);
    }

    @Nullable
    public static Activity getCurrentActivity() {
        if (tq()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (a.tn().isEnable()) {
            return a.tn().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (tq()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (a.tn().isEnable()) {
            return a.tn().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        return tq() || a.tn().isEnable();
    }

    public static b tp() {
        if (XG == null) {
            synchronized (b.class) {
                if (XG == null) {
                    XG = new b();
                }
            }
        }
        return XG;
    }

    public static boolean tq() {
        try {
            if (be.X(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getApiVersion(), BuildConfig.VERSION_NAME)) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void init(Context context) {
        if (this.EL.get() || context == null) {
            return;
        }
        this.EL.set(true);
        try {
            if (be.X(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getApiVersion(), BuildConfig.VERSION_NAME)) {
                this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.c.b.1
                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityCreated(activity, bundle);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityDestroyed(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.1.4
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityDestroyed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityPaused(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.1.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityPaused(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityResumed(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.1.2
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityResumed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToBackground() {
                        com.kwad.sdk.core.e.b.C("LifecycleHolder", "onBackToBackground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.1.6
                            public static void c(c cVar) {
                                cVar.onBackToBackground();
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.kwad.sdk.d.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToForeground() {
                        com.kwad.sdk.core.e.b.C("LifecycleHolder", "onBackToForeground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.1.5
                            public static void c(c cVar) {
                                cVar.onBackToForeground();
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.kwad.sdk.d.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }
                });
            } else {
                com.kwad.sdk.core.e.b.C("LifecycleHolder", "init KSLifecycleObserver not support");
            }
        } catch (Throwable unused) {
        }
        Context applicationContext = bj.getApplicationContext(context);
        if (applicationContext instanceof Application) {
            this.mApplication = (Application) applicationContext;
            a.tn().init(this.mApplication);
            a.tn().a(this);
        }
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityCreated(activity, bundle);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onActivityDestroyed(final Activity activity) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityDestroyed(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onActivityPaused(final Activity activity) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityPaused(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onActivityResumed(final Activity activity) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityResumed(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToBackground() {
        com.kwad.sdk.core.e.b.C("LifecycleHolder", "onBackToBackground old");
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.7
            public static void c(c cVar) {
                cVar.onBackToBackground();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.d.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToForeground() {
        com.kwad.sdk.core.e.b.C("LifecycleHolder", "onBackToForeground old");
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.c.b.6
            public static void c(c cVar) {
                cVar.onBackToForeground();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.d.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }
}
