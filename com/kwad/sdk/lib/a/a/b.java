package com.kwad.sdk.lib.a.a;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.a.c;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.widget.recycler.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b<PAGE, MODEL> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f38466d;

    /* renamed from: e  reason: collision with root package name */
    public KsFragment f38467e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f38468f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f38469g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f38470h;

    /* renamed from: i  reason: collision with root package name */
    public d f38471i;
    public RefreshLayout j;
    public com.kwad.sdk.lib.a.b<PAGE> k;
    public int l;

    public b() {
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
        this.f38466d = new ArrayList();
    }
}
