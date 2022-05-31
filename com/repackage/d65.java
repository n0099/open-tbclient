package com.repackage;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface d65 extends w55 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
