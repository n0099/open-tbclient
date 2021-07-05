package com.kwad.sdk.lib.widget.recycler.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.recycler.b.a.C0475a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class a<MODEL, CallerContext extends C0475a<MODEL>> extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f38566a;

    /* renamed from: b  reason: collision with root package name */
    public final CallerContext f38567b;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0475a<MODEL> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public KsFragment f38568d;

        /* renamed from: e  reason: collision with root package name */
        public RecyclerView f38569e;

        /* renamed from: f  reason: collision with root package name */
        public c<?, MODEL> f38570f;

        /* renamed from: g  reason: collision with root package name */
        public View f38571g;

        /* renamed from: h  reason: collision with root package name */
        public int f38572h;

        /* renamed from: i  reason: collision with root package name */
        public MODEL f38573i;

        public C0475a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, presenter, callercontext};
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
        this.f38567b = callercontext;
        callercontext.f38571g = view;
        this.f38566a = presenter;
        presenter.a(view);
    }
}
