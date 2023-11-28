package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import androidx.transition.Transition;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.kwad.sdk.ranger.c;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Version;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
/* loaded from: classes10.dex */
public class RangerHelper {
    public static volatile boolean aLH;
    public static List<String> aLI;
    public static d aLJ;
    public static List<OkHttpClient> aLK = new ArrayList();

    public static boolean Jd() {
        String userAgent;
        try {
            userAgent = Version.userAgent();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(userAgent)) {
            com.kwad.sdk.core.e.c.d("Ranger_Helper", "TextUtils.isEmpty(userAgent)");
            return false;
        }
        com.kwad.sdk.core.e.c.d("Ranger_Helper", "userAgent:" + userAgent);
        String replace = userAgent.replace("okhttp/", "");
        if (!replace.startsWith("3.")) {
            return false;
        }
        int parseInt = Integer.parseInt(replace.replaceAll("\\.", ""));
        if (parseInt < 390 || parseInt > 3131) {
            return false;
        }
        return true;
    }

    @Keep
    public static void replaceInternal() {
        if (aLH) {
            return;
        }
        if (!Jd()) {
            aLH = true;
            return;
        }
        final Internal internal = (Internal) s.c(Internal.class, Transition.MATCH_INSTANCE_STR);
        if (internal == null) {
            aLH = true;
            return;
        }
        com.kwad.sdk.core.e.c.d("Ranger_Helper", "internal:" + internal.getClass().getName());
        try {
            s.a(internal, Transition.MATCH_INSTANCE_STR, new Internal() { // from class: com.kwad.sdk.ranger.RangerHelper.1
                @Override // okhttp3.internal.Internal
                @Keep
                public final int code(Response.Builder builder) {
                    try {
                        return Internal.this.code(builder);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                        return -1;
                    }
                }

                @Keep
                public final HttpUrl getHttpUrlChecked(String str) {
                    return (HttpUrl) s.f(Internal.this, "getHttpUrlChecked", str);
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                    Boolean bool = (Boolean) s.f(Internal.this, "isInvalidHttpUrlHost", illegalArgumentException);
                    if (bool == null) {
                        return false;
                    }
                    return bool.booleanValue();
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                    try {
                        return Internal.this.routeDatabase(connectionPool);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final StreamAllocation streamAllocation(Call call) {
                    try {
                        return Internal.this.streamAllocation(call);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Keep
                public final void acquire(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                    RangerHelper.a(streamAllocation);
                    s.f(Internal.this, "acquire", connectionPool, address, streamAllocation, route);
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                    RangerHelper.a(streamAllocation);
                    return (RealConnection) s.f(Internal.this, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, connectionPool, address, streamAllocation, route);
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final void addLenient(Headers.Builder builder, String str) {
                    try {
                        Internal.this.addLenient(builder, str);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                    try {
                        return Internal.this.connectionBecameIdle(connectionPool, realConnection);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                        return false;
                    }
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final boolean equalsNonHost(Address address, Address address2) {
                    Boolean bool = (Boolean) s.f(Internal.this, "equalsNonHost", address, address2);
                    if (bool == null) {
                        return false;
                    }
                    return bool.booleanValue();
                }

                @Keep
                public final void initCodec(Response.Builder builder, HttpCodec httpCodec) {
                    s.f(Internal.this, "initCodec", builder, httpCodec);
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                    try {
                        return Internal.this.newWebSocketCall(okHttpClient, request);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final void put(ConnectionPool connectionPool, RealConnection realConnection) {
                    s.f(Internal.this, "put", connectionPool, realConnection);
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final void setCache(OkHttpClient.Builder builder, InternalCache internalCache) {
                    try {
                        Internal.this.setCache(builder, internalCache);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final IOException timeoutExit(Call call, IOException iOException) {
                    return (IOException) s.f(Internal.this, "timeoutExit", call, iOException);
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final void addLenient(Headers.Builder builder, String str, String str2) {
                    try {
                        Internal.this.addLenient(builder, str, str2);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                    try {
                        Internal.this.apply(connectionSpec, sSLSocket, z);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Override // okhttp3.internal.Internal
                @Keep
                public final Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                    try {
                        return Internal.this.deduplicate(connectionPool, address, streamAllocation);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Keep
                public final RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                    return (RealConnection) s.f(Internal.this, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, connectionPool, address, streamAllocation);
                }
            });
            aLH = true;
        } catch (Throwable th) {
            aLH = true;
            com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
        }
    }

    public static void a(final StreamAllocation streamAllocation) {
        g.schedule(new ay() { // from class: com.kwad.sdk.ranger.RangerHelper.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                RangerHelper.m(s.getField(StreamAllocation.this, NotificationCompat.CATEGORY_CALL));
            }
        }, 0L, TimeUnit.SECONDS);
    }

    public static void c(d dVar) {
        aLJ = dVar;
        aLI = dVar.aLC;
    }

    public static void m(Object obj) {
        if (obj == null) {
            com.kwad.sdk.core.e.c.d("Ranger_Helper", "real call null");
            return;
        }
        try {
            OkHttpClient okHttpClient = (OkHttpClient) s.getField(obj, CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT);
            if (aLK.contains(okHttpClient)) {
                com.kwad.sdk.core.e.c.d("Ranger_Helper", "already invoke");
                return;
            }
            aLK.add(okHttpClient);
            Object field = s.getField(obj, "eventListener");
            if (field != null) {
                com.kwad.sdk.core.e.c.d("Ranger_Helper", "eventListener.getClass().getName():" + field.getClass().getName());
                s.a(okHttpClient, "eventListenerFactory", new c(field, new c.a() { // from class: com.kwad.sdk.ranger.RangerHelper.3
                }));
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e("Ranger_Helper", Log.getStackTraceString(th));
        }
    }
}
