package com.repackage;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface p65 extends i65 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
