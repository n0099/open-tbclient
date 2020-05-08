package com.qiniu.android.utils;

import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class StringMap {
    private Map<String, Object> map;

    /* loaded from: classes5.dex */
    public interface Consumer {
        void K(String str, Object obj);
    }

    public StringMap() {
        this(new HashMap());
    }

    public StringMap(Map<String, Object> map) {
        this.map = map;
    }

    public StringMap L(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public StringMap z(Map<String, String> map) {
        this.map.putAll(map);
        return this;
    }

    public void a(Consumer consumer) {
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            consumer.K(entry.getKey(), entry.getValue());
        }
    }

    public Object get(String str) {
        return this.map.get(str);
    }

    /* renamed from: com.qiniu.android.utils.StringMap$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Consumer {
        private boolean mND;
        final /* synthetic */ StringBuilder mNE;

        @Override // com.qiniu.android.utils.StringMap.Consumer
        public void K(String str, Object obj) {
            if (this.mND) {
                this.mNE.append(ETAG.ITEM_SEPARATOR);
            }
            try {
                this.mNE.append(URLEncoder.encode(str, "UTF-8")).append('=').append(URLEncoder.encode(obj.toString(), "UTF-8"));
                this.mND = true;
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }
}
