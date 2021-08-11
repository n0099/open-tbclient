package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public boolean B;
    public boolean C;
    public boolean D;
    public String E;
    public String F;

    /* renamed from: a  reason: collision with root package name */
    public String f68416a;

    /* renamed from: b  reason: collision with root package name */
    public String f68417b;

    /* renamed from: c  reason: collision with root package name */
    public String f68418c;

    /* renamed from: d  reason: collision with root package name */
    public String f68419d;

    /* renamed from: e  reason: collision with root package name */
    public List<StatisticModel.PackageStatisticModel.DownloadFailRecords> f68420e;

    /* renamed from: f  reason: collision with root package name */
    public long f68421f;

    /* renamed from: g  reason: collision with root package name */
    public long f68422g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68423h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68424i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f68425j;
    public boolean k;
    public long l;
    public long m;
    public long n;
    public long o;
    public String p;
    public Long q;
    public Long r;
    public String s;
    public String t;
    public String u;
    public String v;
    public List<StatisticModel.PackageStatisticModel.DownloadFailRecords> w;
    public long x;
    public long y;
    public long z;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68420e = new CopyOnWriteArrayList();
        this.w = new CopyOnWriteArrayList();
    }
}
