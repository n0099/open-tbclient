package d.a.p0;

import android.content.SharedPreferences;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.Flow;
import com.baidu.ubc.IRemoteUBCService;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e0 implements UBCManager {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f63946a = AppConfig.isDebug();

    public final IRemoteUBCService a() throws RemoteException {
        return UBC.getProxy();
    }

    public final Flow b(String str, String str2, int i2) {
        Flow flow = null;
        try {
            flow = a().ubcBeginFlow(str, str2, i2);
            if (f63946a) {
                Log.d("UBCServiceManager", "flow id " + str + " beginFlow  process name " + d.a.e0.b.a.a.b() + "flow hashCode " + flow.hashCode() + " handle id " + flow.getHandle());
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        return flow == null ? new Flow() : flow;
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str) {
        return beginFlow(str, "", 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEvent(Flow flow, String str) {
        flowAddEvent(flow, str, null);
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEventWithDate(Flow flow, String str, String str2, long j) {
        if (f63946a) {
            Log.d("UBCServiceManager", " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid());
        }
        if (flow == null || !flow.getValid()) {
            return;
        }
        if (d.a.e0.b.a.a.g()) {
            d.q().y(flow.getId(), str, flow.getHandle(), str2, j, flow.getOption());
            return;
        }
        try {
            UBC.getProxy().flowAddEventWithTime(flow, str, str2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowCancel(Flow flow) {
        if (f63946a) {
            Log.d("UBCServiceManager", "cancel flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid());
        }
        if (flow == null || !flow.getValid()) {
            return;
        }
        if (d.a.e0.b.a.a.g()) {
            d.q().l(flow.getId(), flow.getHandle());
            return;
        }
        try {
            UBC.getProxy().flowCancel(flow);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowEnd(Flow flow) {
        if (f63946a) {
            Log.d("UBCServiceManager", "end flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid());
        }
        if (flow == null || !flow.getValid()) {
            return;
        }
        if (d.a.e0.b.a.a.g()) {
            JSONArray jSONArray = new JSONArray();
            if (flow.getSlotMaps() != null && (r1 = flow.getSlotMaps().entrySet().iterator()) != null) {
                for (Map.Entry<String, Slot> entry : flow.getSlotMaps().entrySet()) {
                    Slot value = entry.getValue();
                    if (value.d() && !value.e()) {
                        value.f(System.currentTimeMillis());
                    }
                    JSONObject b2 = entry.getValue().b();
                    if (b2 != null) {
                        jSONArray.put(b2);
                    }
                }
            }
            d.q().n(flow.getId(), flow.getHandle(), jSONArray);
            return;
        }
        try {
            UBC.getProxy().flowEnd(flow);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowEndSlot(Flow flow, String str) {
        Slot slot;
        if (flow == null || !flow.getValid() || TextUtils.isEmpty(str) || (slot = flow.getSlotMaps().get(str)) == null || !slot.d() || slot.e()) {
            return;
        }
        slot.f(System.currentTimeMillis());
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValue(Flow flow, String str) {
        if (f63946a) {
            Log.d("UBCServiceManager", " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid());
        }
        if (flow == null || !flow.getValid()) {
            return;
        }
        if (d.a.e0.b.a.a.g()) {
            d.q().C(flow.getId(), flow.getHandle(), str);
            return;
        }
        try {
            UBC.getProxy().flowSetValue(flow, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValueWithDuration(Flow flow, String str) {
        if (f63946a) {
            Log.d("UBCServiceManager", " flow setValueWithDuration, mId:" + flow.getId() + " handle: " + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid());
        }
        if (flow == null || !flow.getValid()) {
            return;
        }
        if (d.a.e0.b.a.a.g()) {
            JSONObject jSONObject = new JSONObject();
            try {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - flow.getStartTime())) / 1000.0f;
                if (currentTimeMillis < 0.0f) {
                    currentTimeMillis = 0.0f;
                }
                jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis)));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("option", str);
                }
                if (f63946a) {
                    Log.d("UBCServiceManager", " flow setValueWithDuration, mId:" + flow.getId() + ", duration: " + jSONObject.toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d.q().C(flow.getId(), flow.getHandle(), jSONObject.toString());
            return;
        }
        try {
            UBC.getProxy().flowSetValueWithDuration(flow, str);
        } catch (RemoteException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowStartSlot(Flow flow, String str, JSONObject jSONObject) {
        if (flow == null || !flow.getValid() || TextUtils.isEmpty(str)) {
            return;
        }
        Slot slot = flow.getSlotMaps().get(str);
        if (slot == null) {
            flow.getSlotMaps().put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
            return;
        }
        slot.g(jSONObject);
    }

    @Override // com.baidu.ubc.UBCManager
    public void flush() {
        if (f63946a) {
            Log.d("UBCServiceManager", "flush");
        }
        d.q().p();
    }

    @Override // com.baidu.ubc.UBCManager
    public String getUploadType(String str) {
        if (d.a.e0.b.a.a.g()) {
            return d.q().r(str);
        }
        try {
            return UBC.getProxy().getUploadType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public boolean isUBCDebug() {
        if (AppConfig.isDebug()) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_UBC_DEBUG", AppConfig.isDebug());
        }
        return false;
    }

    @Override // com.baidu.ubc.UBCManager
    public boolean isUBCSample() {
        if (AppConfig.isDebug()) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_UBC_SAMPLE", false);
        }
        return true;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str) {
        onEvent(str, "", 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public void registerConfig(x xVar) {
        registerConfig(xVar, false, null);
    }

    @Override // com.baidu.ubc.UBCManager
    public void setUBCDebug(boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit();
        edit.putBoolean("KEY_UBC_DEBUG", z);
        edit.commit();
    }

    @Override // com.baidu.ubc.UBCManager
    public void setUBCSample(boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit();
        edit.putBoolean("KEY_UBC_SAMPLE", z);
        edit.commit();
    }

    @Override // com.baidu.ubc.UBCManager
    public void upload() {
        if (f63946a) {
            Log.d("UBCServiceManager", "upload all data");
        }
        d.q().D();
    }

    @Override // com.baidu.ubc.UBCManager
    public void uploadFailedData() {
        if (f63946a) {
            Log.d("UBCServiceManager", "uploadFailedData and quality data");
        }
        d.q().w();
        d.q().A();
    }

    @Override // com.baidu.ubc.UBCManager
    public void uploadLocalDatas() {
        if (d.a.e0.b.a.a.g()) {
            d.q().J();
            return;
        }
        try {
            UBC.getProxy().uploadLocalDatas();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, int i2) {
        return beginFlow(str, "", i2);
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEvent(Flow flow, String str, String str2) {
        if (f63946a) {
            Log.d("UBCServiceManager", " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid());
        }
        if (flow == null || !flow.getValid()) {
            return;
        }
        if (d.a.e0.b.a.a.g()) {
            d.q().x(flow.getId(), str, flow.getHandle(), str2, flow.getOption());
            return;
        }
        try {
            UBC.getProxy().flowAddEvent(flow, str, str2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, int i2) {
        onEvent(str, "", i2);
    }

    @Override // com.baidu.ubc.UBCManager
    public void registerConfig(x xVar, boolean z, t tVar) {
        d.q().B(xVar, z, tVar);
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, String str2) {
        return beginFlow(str, str2, 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, String str2) {
        onEvent(str, str2, 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, JSONObject jSONObject) {
        return beginFlow(str, jSONObject, 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, JSONObject jSONObject) {
        onEvent(str, jSONObject, 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, Map<String, String> map) {
        return beginFlow(str, map, 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, Map<String, String> map) {
        onEvent(str, map, 0);
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, Map<String, String> map, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            if (f63946a) {
                Log.d("UBCServiceManager", "UBC beginFlow# exception:" + e2.getMessage());
            }
        }
        return beginFlow(str, jSONObject.toString(), i2);
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, Map<String, String> map, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            if (f63946a) {
                Log.d("UBCServiceManager", "UBC onEvent# exception:" + e2.getMessage());
            }
        }
        onEvent(str, jSONObject.toString(), i2);
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValue(Flow flow, Map<String, String> map) {
        if (flow == null || !flow.getValid()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            if (f63946a) {
                Log.d("UBCServiceManager", "UBC beginFlow# exception:" + e2.getMessage());
            }
        }
        if (f63946a) {
            Log.d("UBCServiceManager", " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + jSONObject.toString());
        }
        flowSetValue(flow, jSONObject.toString());
    }

    @Override // com.baidu.ubc.UBCManager
    public Flow beginFlow(String str, String str2, int i2) {
        if (d.a.e0.b.a.a.g()) {
            if (TextUtils.isEmpty(str)) {
                if (f63946a) {
                    throw new IllegalArgumentException("UBC beginFlow#flowId must not be null.");
                }
                return null;
            }
            if (f63946a) {
                Log.d("UBCServiceManager", "begin flow id:" + str + " value:" + str2);
            }
            return d.q().j(str, str2, i2);
        }
        return b(str, str2, i2);
    }

    @Override // com.baidu.ubc.UBCManager
    public void onEvent(String str, String str2, int i2) {
        int length;
        if (f63946a && !TextUtils.isEmpty(str2) && (length = str2.getBytes().length) > g.m().o()) {
            Log.e("UBCServiceManager", "UBC log too large, id=" + str + ", content=" + str2);
            throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%d), log id=%s, please deal with. Any question connect UBC owner", Integer.valueOf(length), Integer.valueOf(g.m().o()), str));
        } else if (d.a.e0.b.a.a.g()) {
            if (UBC.getUBCContext() == null && TextUtils.isEmpty(str)) {
                if (f63946a) {
                    throw new IllegalArgumentException("UBC onEvent#eventId must not be null.");
                }
                return;
            }
            if (f63946a) {
                Log.d("UBCServiceManager", "on event id:" + str + " value:" + str2);
            }
            d.q().u(str, str2, i2);
        } else {
            try {
                a().ubcOnEvent(str, str2, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public Flow beginFlow(String str, JSONObject jSONObject, int i2) {
        if (d.a.e0.b.a.a.g()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (f63946a) {
                Log.d("UBCServiceManager", "begin flow id:" + str + " value:" + jSONObject);
            }
            return d.q().k(str, jSONObject, i2);
        }
        return b(str, jSONObject.toString(), i2);
    }

    @Override // com.baidu.ubc.UBCManager
    public void onEvent(String str, JSONObject jSONObject, int i2) {
        if (d.a.e0.b.a.a.g()) {
            if (UBC.getUBCContext() == null && TextUtils.isEmpty(str)) {
                return;
            }
            if (f63946a) {
                Log.d("UBCServiceManager", "on event id:" + str + " value:" + jSONObject.toString());
            }
            d.q().v(str, jSONObject, i2);
            return;
        }
        try {
            a().ubcOnEvent(str, jSONObject.toString(), i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
