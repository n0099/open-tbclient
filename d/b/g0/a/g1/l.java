package d.b.g0.a.g1;

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
import d.b.g0.a.t1.k.a0;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class l extends a0 {
    public l(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/webSocket");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        return false;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.b.g0.a.r1.e eVar) {
        if (a0.f46288b) {
            Log.d("websocket", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            d.b.g0.a.c0.c.b("websocket", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46288b) {
                Log.d("websocket", "websocket --- illegal swanApp");
            }
            return false;
        } else if (TextUtils.isEmpty(eVar.f45740f)) {
            d.b.g0.a.c0.c.b("websocket", "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (a0.f46288b) {
                Log.d("websocket", "websocket --- none swanApp id");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.g0.a.c0.c.b("websocket", "no params found");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "no params found");
                if (a0.f46288b) {
                    Log.d("websocket", "websocket --- none params found");
                }
                return false;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1597844571) {
                    if (hashCode != -1293540435) {
                        if (hashCode == 1991859579 && str.equals("/swanAPI/webSocket/close")) {
                            return k(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, eVar);
                        }
                    } else if (str.equals("/swanAPI/webSocket/connect")) {
                        return l(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, eVar);
                    }
                } else if (str.equals("/swanAPI/webSocket/send")) {
                    return m(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, eVar);
                }
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
    }

    public final IWebSocketListener j(JSONObject jSONObject, CallbackHandler callbackHandler) {
        return new a(new WeakReference(callbackHandler), jSONObject.getString("onOpen"), jSONObject.getString("onMessage"), jSONObject.getString("onClose"), jSONObject.getString("onError"));
    }

    public final boolean k(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (!jSONObject.has("taskID")) {
            d.b.g0.a.c0.c.b("websocket", "taskID lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID lose");
            if (a0.f46288b) {
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
                Intrinsics.checkExpressionValueIsNotNull(taskId, "taskId");
                Intrinsics.checkExpressionValueIsNotNull(reason, "reason");
                webSocketManager.close(taskId, optInt, reason);
                eVar.Y().c(taskId);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } catch (Exception e2) {
                d.b.g0.a.c0.c.b("websocket", e2.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                if (a0.f46288b) {
                    Log.d("websocket", "close --- " + e2.getMessage());
                }
                k Y = eVar.Y();
                Intrinsics.checkExpressionValueIsNotNull(taskId, "taskId");
                Y.c(taskId);
                return false;
            }
        } catch (Throwable th) {
            k Y2 = eVar.Y();
            Intrinsics.checkExpressionValueIsNotNull(taskId, "taskId");
            Y2.c(taskId);
            throw th;
        }
    }

    public final boolean l(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (jSONObject.has("url") && jSONObject.has("cb")) {
            JSONObject cb = jSONObject.getJSONObject("cb");
            if (cb.has("onOpen") && cb.has("onMessage") && cb.has("onClose") && cb.has("onError")) {
                JSONObject jSONObject2 = new JSONObject();
                if (!eVar.Y().a()) {
                    jSONObject2.put("errno", "1");
                } else {
                    String string = jSONObject.getString("url");
                    String optString = jSONObject.optString("__plugin__");
                    int c2 = d.b.g0.a.s1.a.b.c("socket", string, optString);
                    if (c2 == 1) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
                        return false;
                    } else if (c2 != 2) {
                        WebSocketRequest fromJSON = WebSocketRequest.Companion.fromJSON(jSONObject);
                        if (!TextUtils.isEmpty(optString)) {
                            d.b.g0.l.k.h g2 = d.b.g0.a.l1.g.b.g(optString);
                            Map<String, String> headers = fromJSON.getHeaders();
                            if (headers == null) {
                                headers = new LinkedHashMap<>();
                                fromJSON.setHeaders(headers);
                            }
                            String b2 = d.b.g0.a.l1.g.a.b(g2);
                            Intrinsics.checkExpressionValueIsNotNull(b2, "SwanPluginHostSign.hostSign(pmsPlugin)");
                            headers.put("X-SWAN-HOSTSIGN", b2);
                        }
                        Intrinsics.checkExpressionValueIsNotNull(cb, "cb");
                        try {
                            WebSocketTask connect = WebSocketManager.INSTANCE.connect(fromJSON, j(cb, callbackHandler));
                            jSONObject2.put("errno", "0");
                            jSONObject2.put("task", connect.toJSON());
                            eVar.Y().b(connect);
                        } catch (Exception e2) {
                            d.b.g0.a.c0.c.b("websocket", e2.getMessage());
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                            if (a0.f46288b) {
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
            d.b.g0.a.c0.c.b("websocket", "websocket callback lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "websocket callback lose");
            if (a0.f46288b) {
                Log.d("websocket", "connect --- websocket callback lose");
            }
            return false;
        }
        d.b.g0.a.c0.c.b("websocket", "url or cb lose");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "url or cb lose");
        if (a0.f46288b) {
            Log.d("websocket", "connect --- url or cb lose");
        }
        return false;
    }

    public final boolean m(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (jSONObject.has("taskID") && jSONObject.has("data")) {
            String taskId = jSONObject.getString("taskID");
            String data = jSONObject.getString("data");
            try {
                if (jSONObject.optString("dataType", "string").equals("arrayBuffer")) {
                    ByteBuffer buffer = ByteBuffer.wrap(Base64.decode(data, 2));
                    WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                    Intrinsics.checkExpressionValueIsNotNull(taskId, "taskId");
                    Intrinsics.checkExpressionValueIsNotNull(buffer, "buffer");
                    webSocketManager.send(taskId, buffer);
                } else {
                    WebSocketManager webSocketManager2 = WebSocketManager.INSTANCE;
                    Intrinsics.checkExpressionValueIsNotNull(taskId, "taskId");
                    Intrinsics.checkExpressionValueIsNotNull(data, "data");
                    webSocketManager2.send(taskId, data);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } catch (Exception e2) {
                d.b.g0.a.c0.c.b("websocket", e2.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                if (a0.f46288b) {
                    Log.d("websocket", "send --- " + e2.getMessage());
                }
                return false;
            }
        }
        d.b.g0.a.c0.c.b("websocket", "taskID or data lose");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID or data lose");
        if (a0.f46288b) {
            Log.d("websocket", "send --- taskID or data lose");
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static final class a implements IWebSocketListener {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WeakReference f44547f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44548g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44549h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        public a(WeakReference weakReference, String str, String str2, String str3, String str4) {
            this.f44547f = weakReference;
            this.f44548g = str;
            this.f44549h = str2;
            this.i = str3;
            this.j = str4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            d.b.g0.a.r1.e c2;
            k Y;
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
            CallbackHandler callbackHandler = (CallbackHandler) this.f44547f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.i, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString("taskID") : null;
            if (string == null || (c2 = l.this.c()) == null || (Y = c2.Y()) == null) {
                return;
            }
            Y.c(string);
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            d.b.g0.a.r1.e c2;
            k Y;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errMsg", th.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "error happen");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.f44547f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.j, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString("taskID") : null;
            if (string == null || (c2 = l.this.c()) == null || (Y = c2.Y()) == null) {
                return;
            }
            Y.c(string);
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", str);
            jSONObject.put("dataType", "string");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", "0");
            jSONObject2.put("message", "message received");
            jSONObject2.put("data", jSONObject);
            CallbackHandler callbackHandler = (CallbackHandler) this.f44547f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.f44549h, jSONObject2.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> map) {
            JSONObject jSONObject = new JSONObject(map);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "websocket open success");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.f44547f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.f44548g, jSONObject3.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            String encodeToString = Base64.encodeToString(bArr, 2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", encodeToString);
            jSONObject.put("dataType", "arrayBuffer");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", "0");
            jSONObject2.put("message", "message received");
            jSONObject2.put("data", jSONObject);
            CallbackHandler callbackHandler = (CallbackHandler) this.f44547f.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.f44549h, jSONObject2.toString());
            }
        }
    }
}
