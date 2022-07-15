package com.repackage;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface u75 extends n75 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
