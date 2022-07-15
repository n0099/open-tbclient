package com.kwad.sdk.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.utils.bf;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class a implements b {
    public static volatile a a;
    public static final List<b> c = new CopyOnWriteArrayList();
    @Nullable
    public Application b;
    public boolean d = false;

    public static void a(b bVar) {
        c.add(bVar);
    }

    public static <T> void a(com.kwad.sdk.d.a<b> aVar) {
        for (b bVar : c) {
            if (bVar != null) {
                aVar.a(bVar);
            }
        }
    }

    public static void b(b bVar) {
        c.remove(bVar);
    }

    public static a c() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static boolean d() {
        try {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        } catch (Throwable unused) {
            return KSLifecycleOld.a().isAppOnForeground();
        }
    }

    @Nullable
    public static Activity e() {
        try {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        } catch (Throwable unused) {
            return KSLifecycleOld.a().getCurrentActivity();
        }
    }

    @Override // com.kwad.sdk.core.lifecycle.b
    public final void a() {
        com.kwad.sdk.core.d.b.c("LifecycleHolder", "onBackToForeground old method");
        a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.6
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public static void a2(b bVar) {
                bVar.a();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.d.a
            public final /* bridge */ /* synthetic */ void a(b bVar) {
                a2(bVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.lifecycle.b
    public final void a(final Activity activity) {
        a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(b bVar) {
                bVar.a(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.lifecycle.b
    public final void a(final Activity activity, final Bundle bundle) {
        a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(b bVar) {
                bVar.a(activity, bundle);
            }
        });
    }

    public final void a(Context context) {
        try {
            if (!this.d && context != null) {
                this.d = true;
                this.b = KSLifecycleObserver.getInstance().getApplication();
                KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.lifecycle.a.1
                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                        a aVar = a.this;
                        a.a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            public void a(b bVar) {
                                bVar.a(activity, bundle);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityDestroyed(final Activity activity) {
                        a aVar = a.this;
                        a.a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.1.4
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            public void a(b bVar) {
                                bVar.c(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityPaused(final Activity activity) {
                        a aVar = a.this;
                        a.a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.1.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            public void a(b bVar) {
                                bVar.b(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityResumed(final Activity activity) {
                        a aVar = a.this;
                        a.a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.1.2
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            public void a(b bVar) {
                                bVar.a(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToBackground() {
                        com.kwad.sdk.core.d.b.c("LifecycleHolder", "onBackToBackground");
                        a aVar = a.this;
                        a.a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.1.6
                            /* renamed from: a  reason: avoid collision after fix types in other method */
                            public static void a2(b bVar) {
                                bVar.b();
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.kwad.sdk.d.a
                            public final /* bridge */ /* synthetic */ void a(b bVar) {
                                a2(bVar);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToForeground() {
                        com.kwad.sdk.core.d.b.c("LifecycleHolder", "onBackToForeground");
                        a aVar = a.this;
                        a.a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.1.5
                            /* renamed from: a  reason: avoid collision after fix types in other method */
                            public static void a2(b bVar) {
                                bVar.a();
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.kwad.sdk.d.a
                            public final /* bridge */ /* synthetic */ void a(b bVar) {
                                a2(bVar);
                            }
                        });
                    }
                });
            }
        } catch (Throwable unused) {
            Context a2 = bf.a(context);
            com.kwad.sdk.core.d.b.a("LifecycleHolder", "init KSLifecycleOld");
            if (a2 instanceof Application) {
                this.b = (Application) a2;
                KSLifecycleOld.a().a(this.b);
                KSLifecycleOld.a().registerLifecycleListener(this);
            }
        }
    }

    @Override // com.kwad.sdk.core.lifecycle.b
    public final void b() {
        com.kwad.sdk.core.d.b.c("LifecycleHolder", "onBackToBackground old method");
        a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.7
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public static void a2(b bVar) {
                bVar.b();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.d.a
            public final /* bridge */ /* synthetic */ void a(b bVar) {
                a2(bVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.lifecycle.b
    public final void b(final Activity activity) {
        a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(b bVar) {
                bVar.b(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.lifecycle.b
    public final void c(final Activity activity) {
        a(new com.kwad.sdk.d.a<b>() { // from class: com.kwad.sdk.core.lifecycle.a.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(b bVar) {
                bVar.c(activity);
            }
        });
    }
}
