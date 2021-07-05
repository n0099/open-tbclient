package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends RecyclerView.Adapter<C0416a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f35570a;

    /* renamed from: b  reason: collision with root package name */
    public final SceneImpl f35571b;

    /* renamed from: c  reason: collision with root package name */
    public long f35572c;

    /* renamed from: d  reason: collision with root package name */
    public long f35573d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f35574e;

    /* renamed from: f  reason: collision with root package name */
    public Context f35575f;

    /* renamed from: g  reason: collision with root package name */
    public TrendsPanelLayout.b f35576g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0416a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35577a;

        /* renamed from: b  reason: collision with root package name */
        public TrendListItemView f35578b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0416a(a aVar, TrendListItemView trendListItemView) {
            super(trendListItemView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, trendListItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35577a = aVar;
            this.f35578b = trendListItemView;
        }

        public void a(@NonNull TrendInfo trendInfo, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, trendInfo, i2) == null) || this.f35578b == null) {
                return;
            }
            this.f35578b.a(trendInfo, this.f35577a.f35572c == trendInfo.trendId);
            this.f35578b.setOnClickListener(new View.OnClickListener(this, trendInfo, i2) { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendInfo f35579a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f35580b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ C0416a f35581c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, trendInfo, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35581c = this;
                    this.f35579a = trendInfo;
                    this.f35580b = i2;
                }

                /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onClick(View view) {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view) != null) {
                        return;
                    }
                    TrendInfo trendInfo2 = this.f35579a;
                    if (trendInfo2 != null) {
                        long j = trendInfo2.offlineTime;
                        if (j > 0 && j < System.currentTimeMillis()) {
                            z = true;
                            if (z) {
                                this.f35581c.f35577a.f35576g.a(this.f35581c.f35578b, this.f35579a, this.f35580b);
                                return;
                            } else {
                                p.a(this.f35581c.f35577a.f35575f, this.f35581c.f35577a.f35575f.getString(R.string.ksad_trend_is_no_valid));
                                return;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            });
        }
    }

    public a(Context context, @NonNull b bVar, TrendsPanelLayout.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35574e = new ArrayList();
        this.f35575f = context;
        this.f35571b = bVar.f35584c;
        this.f35570a = LayoutInflater.from(context);
        this.f35572c = bVar.f35583b;
        if (bVar.f35582a != null) {
            this.f35574e.clear();
            for (TrendInfo trendInfo : bVar.f35582a) {
                if (trendInfo != null) {
                    this.f35574e.add(trendInfo);
                }
            }
        }
        this.f35576g = bVar2;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            long j = i2;
            if (j > this.f35573d) {
                this.f35573d = j;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C0416a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            TrendListItemView trendListItemView = (TrendListItemView) this.f35570a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
            trendListItemView.setAdScene(this.f35571b);
            return new C0416a(this, trendListItemView);
        }
        return (C0416a) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0416a c0416a, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0416a, i2) == null) {
            c0416a.a(this.f35574e.get(i2), i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35574e.size() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            a(i2);
            return super.getItemViewType(i2);
        }
        return invokeI.intValue;
    }
}
