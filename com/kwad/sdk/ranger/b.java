package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.model.YYOption;
import com.kwad.sdk.ranger.a.a;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    public String value;

    /* loaded from: classes10.dex */
    public static class a {
        public static final b aLz = new b((byte) 0);
    }

    public b() {
    }

    public static b IX() {
        return a.aLz;
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static Object c(com.kwad.sdk.ranger.a.a aVar) {
        if (aVar.aLX) {
            try {
                return s.c(Class.forName(aVar.aLV), aVar.aLW);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.w(TAG, Log.getStackTraceString(e));
            }
        } else {
            Object obj = aVar.aLU;
            if (obj != null) {
                return s.getField(obj, aVar.aLW);
            }
        }
        return null;
    }

    private void l(Object obj) {
        if (obj != null) {
            this.value = String.valueOf(obj);
            return;
        }
        com.kwad.sdk.core.e.c.w(TAG, "value is null by ob null");
        this.value = "";
    }

    public final void b(d dVar) {
        List<com.kwad.sdk.ranger.a.a> list;
        if (dVar != null && (list = dVar.aLE) != null && !list.isEmpty()) {
            final List<com.kwad.sdk.ranger.a.a> list2 = dVar.aLE;
            g.schedule(new ay() { // from class: com.kwad.sdk.ranger.b.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    ArrayList arrayList = new ArrayList();
                    for (com.kwad.sdk.ranger.a.a aVar : list2) {
                        if (aVar != null && !TextUtils.isEmpty(aVar.aLY)) {
                            String str = aVar.aLY;
                            b.this.a(aVar);
                            b bVar = b.this;
                            com.kwad.sdk.ranger.b.a.c a2 = b.a(bVar, str, bVar.value);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.kwad.sdk.ranger.b.a.d dVar2 = new com.kwad.sdk.ranger.b.a.d();
                        dVar2.aMn = arrayList;
                        com.kwad.sdk.ranger.b.a.a(dVar2);
                    }
                }
            }, 20L, TimeUnit.SECONDS);
        }
    }

    public static /* synthetic */ com.kwad.sdk.ranger.b.a.c a(b bVar, String str, String str2) {
        return al(str, str2);
    }

    public static Object a(com.kwad.sdk.ranger.a.a aVar, boolean z, Class<?> cls) {
        Object[] Jh = aVar.aLZ.Jh();
        if (Jh != null && Jh.length != 0) {
            if (z) {
                return s.callStaticMethod(cls, aVar.aLZ.name, Jh);
            }
            return s.callMethod(aVar.aLU, aVar.aLZ.name, Jh);
        } else if (z) {
            return s.callStaticMethod(cls, aVar.aLZ.name, new Object[0]);
        } else {
            return s.callMethod(aVar.aLU, aVar.aLZ.name, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.ranger.a.a aVar) {
        String str;
        com.kwad.sdk.ranger.a.a aVar2 = aVar.aMa;
        if (aVar2 != null && !aVar2.Je()) {
            if (!TextUtils.isEmpty(aVar.aLW)) {
                aVar.aMa.aLU = c(aVar);
            } else {
                a.b bVar = aVar.aLZ;
                if (bVar != null && !bVar.Je()) {
                    aVar.aMa.aLU = b(aVar);
                }
            }
            a(aVar.aMa);
        } else if (!TextUtils.isEmpty(aVar.aLW)) {
            l(c(aVar));
        } else {
            a.b bVar2 = aVar.aLZ;
            if (bVar2 != null && !bVar2.Je()) {
                l(b(aVar));
                return;
            }
            String str2 = TAG;
            com.kwad.sdk.core.e.c.d(str2, "node.nodeClassName:" + aVar.aLV);
            if (s.classExists(aVar.aLV)) {
                str = YYOption.IsLive.VALUE_TRUE;
            } else {
                str = "false";
            }
            this.value = str;
        }
    }

    @Nullable
    public static com.kwad.sdk.ranger.b.a.c al(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.kwad.sdk.ranger.b.a.c cVar = new com.kwad.sdk.ranger.b.a.c();
            cVar.name = str;
            cVar.aMm = str2;
            return cVar;
        }
        return null;
    }

    private Object b(com.kwad.sdk.ranger.a.a aVar) {
        Class<?> cls;
        if (aVar.aLZ.aMi) {
            try {
                if (!TextUtils.isEmpty(aVar.aLV)) {
                    cls = Class.forName(aVar.aLV);
                } else if (aVar.aLU != null) {
                    cls = aVar.aLU.getClass();
                } else {
                    cls = null;
                }
                if (cls == null) {
                    return null;
                }
                return a(aVar, true, cls);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.w(TAG, Log.getStackTraceString(e));
                return null;
            }
        } else if (aVar.aLU == null) {
            return null;
        } else {
            return a(aVar, false, (Class<?>) null);
        }
    }
}
