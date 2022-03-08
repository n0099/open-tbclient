package com.tachikoma.core.component.listview;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.listview.viewpager.RecyclerViewPager;
import com.tachikoma.core.component.listview.viewpager.TKOnPageChangeCallbackImpl;
import com.tachikoma.core.component.listview.viewpager.TKViewPagerAdapterExtra;
import com.tachikoma.core.utility.V8Proxy;
import java.util.ArrayList;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes8.dex */
public class TKViewPager extends TKBase<RecyclerViewPager> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKRecyclerAdapter mAdapter;
    public V8Object mDelegate;
    public int mDirection;
    public TKIndicator mIndicator;
    public JSContext.V8AssociateReference mIndicatorAssociateRef;
    public TKOnPageChangeCallbackImpl mPageChangeCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKViewPager(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDirection = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public RecyclerViewPager createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new RecyclerViewPager(context) : (RecyclerViewPager) invokeL.objValue;
    }

    @Override // com.tachikoma.core.component.TKBase
    public void onAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttach();
            getView().setDirection(this.mDirection);
            if (this.mIndicator != null) {
                getView().addItemDecoration(new TKPagerIndicatorDecoration(this.mIndicator.create()));
            }
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            JSContext.V8AssociateReference v8AssociateReference = this.mIndicatorAssociateRef;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
                this.mIndicatorAssociateRef = null;
            }
            V8Proxy.release(this.mDelegate);
        }
    }

    public void registerOnPageChangeCallback(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, v8Object) == null) && V8Proxy.isV8Valid(v8Object)) {
            this.mPageChangeCallback = new TKOnPageChangeCallbackImpl(v8Object, this.mTKJSContext);
            getView().addOnPageListener(new RecyclerViewPager.OnPageChangeListener(this) { // from class: com.tachikoma.core.component.listview.TKViewPager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKViewPager this$0;

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
                    this.this$0 = this;
                }

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.this$0.mPageChangeCallback == null) {
                        return;
                    }
                    this.this$0.mPageChangeCallback.onPageScrollStateChanged(i2);
                }

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.this$0.mPageChangeCallback == null) {
                        return;
                    }
                    this.this$0.mPageChangeCallback.onPageScrolled(i2, f2, i3);
                }

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeListener
                public void onPageSelected(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.this$0.mPageChangeCallback == null) {
                        return;
                    }
                    this.this$0.mPageChangeCallback.onPageSelected(i2);
                }
            });
        }
    }

    public void reloadData() {
        TKRecyclerAdapter tKRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tKRecyclerAdapter = this.mAdapter) == null) {
            return;
        }
        tKRecyclerAdapter.notifyDataSetChanged();
    }

    public void scrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            getView().setCurrentItem(i3, true);
        }
    }

    public void setAdapter(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, v8Object) == null) && V8Proxy.isV8Valid(v8Object)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mTKJSContext);
            arrayList.add(v8Object);
            TKViewPagerAdapterExtra tKViewPagerAdapterExtra = new TKViewPagerAdapterExtra(getContext(), arrayList);
            this.mAdapter = tKViewPagerAdapterExtra;
            V8Object v8Object2 = this.mDelegate;
            if (v8Object2 != null) {
                tKViewPagerAdapterExtra.setV8Delegate(v8Object2);
                V8Proxy.release(this.mDelegate);
            }
            getView().setAdapter(this.mAdapter);
        }
    }

    public void setDirection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mDirection = i2;
        }
    }

    @Deprecated
    public void setIndicator(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v8Object) == null) {
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            this.mIndicator = (TKIndicator) associateReference.nativeObject;
            JSContext.V8AssociateReference v8AssociateReference = this.mIndicatorAssociateRef;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
            }
            this.mIndicatorAssociateRef = associateReference;
        }
    }

    public void setViewPagerDelegate(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, v8Object) == null) && V8Proxy.isV8Valid(v8Object)) {
            TKRecyclerAdapter tKRecyclerAdapter = this.mAdapter;
            if (tKRecyclerAdapter != null) {
                tKRecyclerAdapter.setV8Delegate(v8Object);
            } else {
                this.mDelegate = v8Object.twin();
            }
        }
    }

    public void smoothScrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            getView().setCurrentItem(i3, true);
        }
    }
}
