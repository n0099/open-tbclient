package com.kwad.components.ad.reflux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reflux.a;
import com.kwad.components.ad.reward.c.c;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class KsRefluxNativeView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView kG;
    public b kH;

    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Nullable
        public final com.kwad.components.ad.reflux.kwai.a eE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View view2 = this.itemView;
                if (view2 instanceof com.kwad.components.ad.reflux.kwai.a) {
                    return (com.kwad.components.ad.reflux.kwai.a) view2;
                }
                return null;
            }
            return (com.kwad.components.ad.reflux.kwai.a) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<com.kwad.components.ad.reflux.a> kI;
        public c kJ;
        public Context mContext;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.kI = new ArrayList();
            this.mContext = context;
        }

        public static void a(List<com.kwad.components.ad.reflux.a> list, List<com.kwad.components.ad.reflux.a> list2) {
            com.kwad.components.ad.reflux.a aVar;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, list, list2) == null) {
                int size = list2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    list.add(list2.get(i2));
                    if (i2 == size - 1) {
                        aVar = new com.kwad.components.ad.reflux.a(null);
                        i = -2;
                    } else {
                        aVar = new com.kwad.components.ad.reflux.a(null);
                        i = -1;
                    }
                    aVar.K(i);
                    list.add(aVar);
                }
            }
        }

        public final void d(List<com.kwad.components.ad.reflux.a> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            this.kI.clear();
            a(this.kI, list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.kI.size() : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.kI.get(i).eR() : invokeI.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i) == null) {
                com.kwad.components.ad.reflux.a aVar = this.kI.get(i);
                a aVar2 = (a) viewHolder;
                int itemViewType = aVar2.getItemViewType();
                if (itemViewType == FeedType.FEED_TYPE_UNKNOWN.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_ABOVE.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                    if (aVar.eP()) {
                        aVar.eK();
                        aVar.a(new a.InterfaceC0321a(this) { // from class: com.kwad.components.ad.reflux.KsRefluxNativeView.b.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ b kK;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.kK = this;
                            }

                            @Override // com.kwad.components.ad.reflux.a.InterfaceC0321a
                            public final void eF() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.kK.notifyDataSetChanged();
                                    } catch (IllegalStateException unused) {
                                    }
                                }
                            }
                        });
                    }
                    com.kwad.components.ad.reflux.kwai.a eE = aVar2.eE();
                    if (eE != null) {
                        eE.a(aVar);
                    }
                }
                View view2 = viewHolder.itemView;
                if (view2 instanceof com.kwad.components.ad.reflux.kwai.a) {
                    ((com.kwad.components.ad.reflux.kwai.a) view2).setAdClickListener(new b.a(this, aVar.eJ()) { // from class: com.kwad.components.ad.reflux.KsRefluxNativeView.b.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ b kK;
                        public final /* synthetic */ com.kwad.components.ad.reward.c.b kL;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.kK = this;
                            this.kL = r7;
                        }

                        @Override // com.kwad.components.core.widget.b.a, com.kwad.components.core.widget.b.InterfaceC0376b
                        public final void onAdClicked() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                super.onAdClicked();
                                if (this.kK.kJ != null) {
                                    this.kK.kJ.d(this.kL);
                                }
                            }
                        }

                        @Override // com.kwad.components.core.widget.b.a, com.kwad.components.core.widget.b.InterfaceC0376b
                        public final void onAdShow() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                super.onAdShow();
                                if (this.kK.kJ != null) {
                                    this.kK.kJ.e(this.kL);
                                }
                            }
                        }
                    });
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            View cVar;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
                if (i == FeedType.FEED_TYPE_TEXT_ABOVE.getType()) {
                    cVar = new com.kwad.components.ad.reflux.kwai.c(this.mContext);
                } else if (i == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                    cVar = new com.kwad.components.ad.reflux.kwai.b(this.mContext);
                } else {
                    if (i == -1) {
                        i2 = R.layout.obfuscated_res_0x7f0d0446;
                    } else if (i == -2) {
                        i2 = R.layout.obfuscated_res_0x7f0d044a;
                    } else {
                        cVar = new com.kwad.components.ad.reflux.kwai.c(this.mContext);
                    }
                    cVar = from.inflate(i2, viewGroup, false);
                }
                cVar.setLayoutParams(layoutParams);
                return new a(cVar);
            }
            return (RecyclerView.ViewHolder) invokeLI.objValue;
        }

        public final void setInnerAdInteractionListener(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.kJ = cVar;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxNativeView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        L(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        L(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        L(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        L(context);
    }

    private void L(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0449, this);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0910d9);
            this.kG = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            b bVar = new b(getContext());
            this.kH = bVar;
            bVar.setHasStableIds(true);
            this.kG.setAdapter(this.kH);
        }
    }

    public final void c(List<com.kwad.components.ad.reflux.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.kH.d(list);
        }
    }

    public void setInnerAdInteractionListener(c cVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (bVar = this.kH) == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(cVar);
    }
}
