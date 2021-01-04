package com.opensource.svgaplayer.entities;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes6.dex */
public final class f {
    private final List<g> frames;
    private final String imageKey;

    public final String getImageKey() {
        return this.imageKey;
    }

    public final List<g> eEn() {
        return this.frames;
    }

    public f(JSONObject jSONObject) {
        p.o(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.imageKey = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.iY().isEmpty()) && ((SVGAVideoShapeEntity) n.hj(gVar.iY())).eEd() && arrayList.size() > 0) {
                        gVar.gR(((g) n.hk(arrayList)).iY());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.frames = n.g(arrayList);
    }

    public f(SpriteEntity spriteEntity) {
        ArrayList eLS;
        p.o(spriteEntity, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.imageKey = spriteEntity.imageKey;
        g gVar = null;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            List<FrameEntity> list2 = list;
            ArrayList arrayList = new ArrayList(n.a(list2, 10));
            g gVar2 = gVar;
            for (FrameEntity frameEntity : list2) {
                p.n(frameEntity, AdvanceSetting.NETWORK_TYPE);
                g gVar3 = new g(frameEntity);
                if ((!gVar3.iY().isEmpty()) && ((SVGAVideoShapeEntity) n.hj(gVar3.iY())).eEd() && gVar2 != null) {
                    gVar3.gR(gVar2.iY());
                }
                arrayList.add(gVar3);
                gVar2 = gVar3;
            }
            eLS = arrayList;
        } else {
            eLS = n.eLS();
        }
        this.frames = eLS;
    }
}
