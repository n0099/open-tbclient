package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface b65 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b(@NonNull List<ThreadData> list, @Nullable Map<String, Object> map);
    }

    b65 a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str);

    void b(int i, op4 op4Var, long j);

    void c(@Nullable a aVar);
}
