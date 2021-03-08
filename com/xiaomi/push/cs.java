package com.xiaomi.push;

import java.util.Comparator;
import org.apache.http.NameValuePair;
/* loaded from: classes5.dex */
final class cs implements Comparator<NameValuePair> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(NameValuePair nameValuePair, NameValuePair nameValuePair2) {
        return nameValuePair.getName().compareTo(nameValuePair2.getName());
    }
}
