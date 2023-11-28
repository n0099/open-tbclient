package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bo;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class b implements c<Activity> {
    public static volatile b asY;
    public static final List<c> mListeners = new CopyOnWriteArrayList();
    public final AtomicBoolean JB = new AtomicBoolean(false);
    @Nullable
    public Application mApplication;

    public static b Ct() {
        if (asY == null) {
            synchronized (b.class) {
                if (asY == null) {
                    asY = new b();
                }
            }
        }
        return asY;
    }

    public static boolean Cu() {
        try {
            if (bo.ax(((f) ServiceProvider.get(f.class)).getApiVersion(), "3.3.26")) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public static Activity getCurrentActivity() {
        if (Cu()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (a.Cr().isEnable()) {
            return a.Cr().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (Cu()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (a.Cr().isEnable()) {
            return a.Cr().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        if (!Cu() && !a.Cr().isEnable()) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Application getApplication() {
        return this.mApplication;
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToBackground() {
        com.kwad.sdk.core.e.c.R("LifecycleHolder", "onBackToBackground old");
        c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.7
            public static void c(c cVar) {
                cVar.onBackToBackground();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToForeground() {
        com.kwad.sdk.core.e.c.R("LifecycleHolder", "onBackToForeground old");
        c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.6
            public static void c(c cVar) {
                cVar.onBackToForeground();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityCreated */
    public void a(final Activity activity, final Bundle bundle) {
        c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.a(activity, bundle);
            }
        });
    }

    public static void a(c cVar) {
        mListeners.add(cVar);
    }

    public static void b(c cVar) {
        mListeners.remove(cVar);
    }

    public static <T> void c(com.kwad.sdk.g.a<c> aVar) {
        for (c cVar : mListeners) {
            if (cVar != null) {
                aVar.accept(cVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityDestroyed */
    public void b(final Activity activity) {
        c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.b(activity);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityPaused */
    public void c(final Activity activity) {
        c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.c(activity);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityResumed */
    public void d(final Activity activity) {
        c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.d(activity);
            }
        });
    }

    public final void init(Context context) {
        if (!this.JB.get() && context != null) {
            this.JB.set(true);
            try {
                if (bo.ax(((f) ServiceProvider.get(f.class)).getApiVersion(), "3.3.26")) {
                    this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                    KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.c.b.1
                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityDestroyed(final Activity activity) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.1.4
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.g.a
                                /* renamed from: c */
                                public void accept(c cVar) {
                                    cVar.b(activity);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityPaused(final Activity activity) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.1.3
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.g.a
                                /* renamed from: c */
                                public void accept(c cVar) {
                                    cVar.c(activity);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityResumed(final Activity activity) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.1.2
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.g.a
                                /* renamed from: c */
                                public void accept(c cVar) {
                                    cVar.d(activity);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.g.a
                                /* renamed from: c */
                                public void accept(c cVar) {
                                    cVar.a(activity, bundle);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onBackToBackground() {
                            com.kwad.sdk.core.e.c.R("LifecycleHolder", "onBackToBackground");
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.1.6
                                public static void c(c cVar) {
                                    cVar.onBackToBackground();
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.kwad.sdk.g.a
                                public final /* synthetic */ void accept(c cVar) {
                                    c(cVar);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onBackToForeground() {
                            com.kwad.sdk.core.e.c.R("LifecycleHolder", "onBackToForeground");
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.c.b.1.5
                                public static void c(c cVar) {
                                    cVar.onBackToForeground();
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.kwad.sdk.g.a
                                public final /* synthetic */ void accept(c cVar) {
                                    c(cVar);
                                }
                            });
                        }
                    });
                } else {
                    com.kwad.sdk.core.e.c.R("LifecycleHolder", "init KSLifecycleObserver not support");
                }
            } catch (Throwable unused) {
            }
            Application My = l.My();
            if (My != null) {
                this.mApplication = My;
                a.Cr().init(this.mApplication);
                a.Cr().a(this);
            }
        }
    }
}
