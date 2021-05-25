package d.a.l0.a.n1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import d.a.l0.a.c2.f.a0;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class n extends a0 {
    public n(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/webSocket");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        return false;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (a0.f40949b) {
            Log.d("websocket", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            d.a.l0.a.e0.d.b("websocket", "param is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f40949b) {
                Log.d("websocket", "websocket --- illegal swanApp");
            }
            return false;
        } else if (TextUtils.isEmpty(eVar.f40749f)) {
            d.a.l0.a.e0.d.b("websocket", "aiapp id is invalid");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (a0.f40949b) {
                Log.d("websocket", "websocket --- none swanApp id");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
            if (optParamsAsJo == null) {
                d.a.l0.a.e0.d.b("websocket", "no params found");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "no params found");
                if (a0.f40949b) {
                    Log.d("websocket", "websocket --- none params found");
                }
                return false;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1597844571) {
                    if (hashCode != -1293540435) {
                        if (hashCode == 1991859579 && str.equals("/swanAPI/webSocket/close")) {
                            return k(context, optParamsAsJo, entity, callbackHandler, eVar);
                        }
                    } else if (str.equals("/swanAPI/webSocket/connect")) {
                        return l(context, optParamsAsJo, entity, callbackHandler, eVar);
                    }
                } else if (str.equals("/swanAPI/webSocket/send")) {
                    return m(context, optParamsAsJo, entity, callbackHandler, eVar);
                }
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
    }

    public final IWebSocketListener j(JSONObject jSONObject, CallbackHandler callbackHandler) {
        return new a(new WeakReference(callbackHandler), jSONObject.getString("onOpen"), jSONObject.getString("onMessage"), jSONObject.getString("onClose"), jSONObject.getString("onError"));
    }

    public final boolean k(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (!jSONObject.has("taskID")) {
            d.a.l0.a.e0.d.b("websocket", "taskID lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID lose");
            if (a0.f40949b) {
                Log.d("websocket", "close --- taskID lose");
            }
            return false;
        }
        String taskId = jSONObject.getString("taskID");
        int optInt = jSONObject.optInt("code", 1000);
        String reason = jSONObject.optString("reason", "close normally");
        try {
            try {
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                Intrinsics.checkNotNullExpressionValue(reason, "reason");
                webSocketManager.close(taskId, optInt, reason);
                eVar.b0().c(taskId);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } catch (Exception e2) {
                d.a.l0.a.e0.d.b("websocket", e2.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                if (a0.f40949b) {
                    Log.d("websocket", "close --- " + e2.getMessage());
                }
                k b0 = eVar.b0();
                Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                b0.c(taskId);
                return false;
            }
        } catch (Throwable th) {
            k b02 = eVar.b0();
            Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
            b02.c(taskId);
            throw th;
        }
    }

    public final boolean l(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (jSONObject.has("url") && jSONObject.has("cb")) {
            JSONObject cb = jSONObject.getJSONObject("cb");
            if (cb.has("onOpen") && cb.has("onMessage") && cb.has("onClose") && cb.has("onError")) {
                JSONObject jSONObject2 = new JSONObject();
                if (!eVar.b0().a()) {
                    jSONObject2.put("errno", "1");
                } else {
                    String string = jSONObject.getString("url");
                    String optString = jSONObject.optString("__plugin__");
                    int c2 = d.a.l0.a.b2.a.b.c("socket", string, optString);
                    if (c2 == 1) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
                        return false;
                    } else if (c2 != 2) {
                        WebSocketRequest fromJSON = WebSocketRequest.Companion.fromJSON(jSONObject);
                        if (!TextUtils.isEmpty(optString)) {
                            d.a.l0.n.h.h h2 = d.a.l0.a.t1.g.b.h(optString);
                            Map<String, String> headers = fromJSON.getHeaders();
                            if (headers == null) {
                                headers = new LinkedHashMap<>();
                                fromJSON.setHeaders(headers);
                            }
                            String b2 = d.a.l0.a.t1.g.a.b(h2);
                            Intrinsics.checkNotNullExpressionValue(b2, "SwanPluginHostSign.hostSign(pmsPlugin)");
                            headers.put("X-SWAN-HOSTSIGN", b2);
                        }
                        Intrinsics.checkNotNullExpressionValue(cb, "cb");
                        try {
                            WebSocketTask connect = WebSocketManager.INSTANCE.connect(fromJSON, j(cb, callbackHandler));
                            jSONObject2.put("errno", "0");
                            jSONObject2.put("task", connect.toJSON());
                            eVar.b0().b(connect);
                        } catch (Exception e2) {
                            d.a.l0.a.e0.d.b("websocket", e2.getMessage());
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                            if (a0.f40949b) {
                                Log.d("websocket", "connect --- " + e2.getMessage());
                            }
                            return false;
                        }
                    } else {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "request url header must be https or wss");
                        return false;
                    }
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                return true;
            }
            d.a.l0.a.e0.d.b("websocket", "websocket callback lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "websocket callback lose");
            if (a0.f40949b) {
                Log.d("websocket", "connect --- websocket callback lose");
            }
            return false;
        }
        d.a.l0.a.e0.d.b("websocket", "url or cb lose");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "url or cb lose");
        if (a0.f40949b) {
            Log.d("websocket", "connect --- url or cb lose");
        }
        return false;
    }

    public final boolean m(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (jSONObject.has("taskID") && jSONObject.has("data")) {
            String taskId = jSONObject.getString("taskID");
            String data = jSONObject.getString("data");
            try {
                if (jSONObject.optString("dataType", "string").equals("arrayBuffer")) {
                    ByteBuffer buffer = ByteBuffer.wrap(Base64.decode(data, 2));
                    WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                    Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                    webSocketManager.send(taskId, buffer);
                } else {
                    WebSocketManager webSocketManager2 = WebSocketManager.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                    Intrinsics.checkNotNullExpressionValue(data, "data");
                    webSocketManager2.send(taskId, data);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } catch (Exception e2) {
                d.a.l0.a.e0.d.b("websocket", e2.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                if (a0.f40949b) {
                    Log.d("websocket", "send --- " + e2.getMessage());
                }
                return false;
            }
        }
        d.a.l0.a.e0.d.b("websocket", "taskID or data lose");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID or data lose");
        if (a0.f40949b) {
            Log.d("websocket", "send --- taskID or data lose");
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public static final class a implements IWebSocketListener {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WeakReference f43725f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43726g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43727h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43728i;
        public final /* synthetic */ String j;

        public a(WeakReference weakReference, String str, String str2, String str3, String str4) {
            this.f43725f = weakReference;
            this.f43726g = str;
            this.f43727h = str2;
            this.f43728i = str3;
            this.j = str4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            d.a.l0.a.a2.e c2;
            k b0;
            String optString;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", jSONObject != null ? jSONObject.optInt("code") : 0);
            String str = "";
            if (jSONObject != null && (optString = jSONObject.optString("reason", "")) != null) {
                str = optString;
            }
            jSONObject2.put("reason", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "websocket closed");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.f43725f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.f43728i, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString("taskID") : null;
            if (string == null || (c2 = n.this.c()) == null || (b0 = c2.b0()) == null) {
                return;
            }
            b0.c(string);
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable t, JSONObject jSONObject) {
            d.a.l0.a.a2.e c2;
            k b0;
            Intrinsics.checkNotNullParameter(t, "t");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errMsg", t.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "error happen");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.f43725f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.j, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString("taskID") : null;
            if (string == null || (c2 = n.this.c()) == null || (b0 = c2.b0()) == null) {
                return;
            }
            b0.c(string);
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", message);
            jSONObject.put("dataType", "string");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", "0");
            jSONObject2.put("message", "message received");
            jSONObject2.put("data", jSONObject);
            CallbackHandler callbackHandler = (CallbackHandler) this.f43725f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.f43727h, jSONObject2.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            JSONObject jSONObject = new JSONObject(headers);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "websocket open success");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.f43725f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.f43726g, jSONObject3.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer message) {
            Intrinsics.checkNotNullParameter(message, "message");
            byte[] bArr = new byte[message.remaining()];
            message.get(bArr);
            String encodeToString = Base64.encodeToString(bArr, 2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", encodeToString);
            jSONObject.put("dataType", "arrayBuffer");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", "0");
            jSONObject2.put("message", "message received");
            jSONObject2.put("data", jSONObject);
            CallbackHandler callbackHandler = (CallbackHandler) this.f43725f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.f43727h, jSONObject2.toString());
            }
        }
    }
}
