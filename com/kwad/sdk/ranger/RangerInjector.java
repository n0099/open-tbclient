package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.bytedance.apm.common.utility.Logger;
import com.kwad.sdk.utils.s;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class RangerInjector {

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(String str, long j, long j2, String str2, String str3);

        void onError(String str);
    }

    public static void a(String str, final String str2, final b bVar) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                bVar.onError("getPluginByClass is null");
                return;
            }
            final PluginListener pluginListener = (PluginListener) s.getField(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    s.a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.ranger.RangerInjector.1
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    com.kwad.sdk.core.e.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th) {
                                    b bVar2 = bVar;
                                    if (bVar2 != null) {
                                        bVar2.onError(Log.getStackTraceString(th));
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(str2)) {
                                Issue issue = (Issue) objArr[0];
                                com.kwad.sdk.core.e.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String n = RangerInjector.n(content);
                                    long o = RangerInjector.o(content);
                                    long p = RangerInjector.p(content);
                                    String q = RangerInjector.q(content);
                                    String r = RangerInjector.r(content);
                                    if (bVar != null) {
                                        bVar.a(n, p, o, q, r);
                                    }
                                } catch (Throwable unused) {
                                }
                                pluginListener.onReportIssue(issue);
                            } else if (TextUtils.equals(method.getName(), "onInit")) {
                                pluginListener.onInit((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStart")) {
                                pluginListener.onStart((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), MissionEvent.MESSAGE_STOP)) {
                                pluginListener.onStop((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), MissionEvent.MESSAGE_DESTROY)) {
                                pluginListener.onDestroy((Plugin) objArr[0]);
                            } else {
                                method.invoke(pluginListener, objArr);
                            }
                            return null;
                        }
                    }));
                } catch (Exception e) {
                    bVar.onError(Log.getStackTraceString(e));
                }
            }
        } catch (Exception e2) {
            bVar.onError(Log.getStackTraceString(e2));
        }
    }

    public static String n(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception unused) {
            return "";
        }
    }

    public static long o(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long p(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("time");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String q(JSONObject jSONObject) {
        try {
            return jSONObject.optString("scene");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String r(JSONObject jSONObject) {
        try {
            return jSONObject.optString("process");
        } catch (Exception unused) {
            return "";
        }
    }

    @Keep
    public static void tryProxyOtherOutput(String str, String str2, String str3, final String str4, final a aVar) {
        try {
            final Logger.ILogWritter iLogWritter = (Logger.ILogWritter) s.ao(str, str2);
            if (iLogWritter == null) {
                return;
            }
            Integer num = (Integer) s.ao(str, str3);
            final int i = 4;
            if (num != null) {
                i = num.intValue();
            }
            s.setStaticField(Class.forName(str), str2, new Logger.ILogWritter() { // from class: com.kwad.sdk.ranger.RangerInjector.2
                @Keep
                public final boolean isLoggable(int i2) {
                    return true;
                }

                @Keep
                public final void logD(String str5, String str6) {
                    try {
                        if (i > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6) {
                    try {
                        if (i > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6) {
                    try {
                        if (i > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logK(String str5, String str6) {
                    try {
                        iLogWritter.logK(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6) {
                    try {
                        if (i > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6) {
                    try {
                        if (i > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logD(String str5, String str6, Throwable th) {
                    try {
                        if (i > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6, Throwable th) {
                    try {
                        if (TextUtils.equals(str5, str4) && aVar != null) {
                            Log.getStackTraceString(th);
                        }
                        if (i > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6, Throwable th) {
                    try {
                        if (i > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6, Throwable th) {
                    try {
                        if (i > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6, Throwable th) {
                    try {
                        if (i > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.w("perfMonitor.RangerInjector", Log.getStackTraceString(th));
        }
    }
}
