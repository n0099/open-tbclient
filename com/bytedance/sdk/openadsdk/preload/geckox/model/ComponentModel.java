package com.bytedance.sdk.openadsdk.preload.geckox.model;

import androidx.annotation.Keep;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes6.dex */
public class ComponentModel {
    @c(a = "packages")
    public Map<String, List<UpdatePackage>> packages;
    @c(a = "universal_strategies")
    public Map<String, b> universalStrategies;

    /* loaded from: classes6.dex */
    public static class a {
        @c(a = "c")

        /* renamed from: a  reason: collision with root package name */
        public String f30313a;
        @c(a = "clean_type")

        /* renamed from: b  reason: collision with root package name */
        public int f30314b;
        @c(a = "version")

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f30315c;
    }

    /* loaded from: classes6.dex */
    public static class b {
        @c(a = "specified_clean")

        /* renamed from: a  reason: collision with root package name */
        public List<a> f30316a;
    }

    public Map<String, List<UpdatePackage>> getPackages() {
        return this.packages;
    }

    public Map<String, b> getUniversalStrategies() {
        return this.universalStrategies;
    }
}
