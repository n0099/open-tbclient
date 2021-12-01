package com.tachikoma.core.component;

import android.content.Context;
import java.util.List;
/* loaded from: classes2.dex */
public interface IFactory<T> {
    T newInstance(Context context, List<Object> list);
}
