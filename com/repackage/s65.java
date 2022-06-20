package com.repackage;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface s65 extends l65 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
