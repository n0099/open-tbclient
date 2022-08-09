package com.repackage;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface t85 extends m85 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
