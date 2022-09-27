package com.kwad.components.core.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class KsLogoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleImageLoadingListener PA;
    public a PB;
    public boolean Px;
    public TextView Py;
    public ImageView Pz;

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context) {
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
        this.PA = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView PC;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.PC = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.PC.PB == null) {
                    return;
                }
                a unused = this.PC.PB;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.PC.qg();
                    if (this.PC.PB != null) {
                        a unused = this.PC.PB;
                    }
                }
            }
        };
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.PA = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView PC;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.PC = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.PC.PB == null) {
                    return;
                }
                a unused = this.PC.PB;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.PC.qg();
                    if (this.PC.PB != null) {
                        a unused = this.PC.PB;
                    }
                }
            }
        };
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.PA = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView PC;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.PC = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.PC.PB == null) {
                    return;
                }
                a unused = this.PC.PB;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.PC.qg();
                    if (this.PC.PB != null) {
                        a unused = this.PC.PB;
                    }
                }
            }
        };
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.PA = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView PC;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.PC = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.PC.PB == null) {
                    return;
                }
                a unused = this.PC.PB;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.PC.qg();
                    if (this.PC.PB != null) {
                        a unused = this.PC.PB;
                    }
                }
            }
        };
        if (z) {
            setBackgroundResource(R.drawable.obfuscated_res_0x7f080c85);
        }
        init(context);
    }

    private void init(Context context) {
        TextView textView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0440, this);
            this.Py = (TextView) findViewById(R.id.obfuscated_res_0x7f091102);
            this.Pz = (ImageView) findViewById(R.id.obfuscated_res_0x7f091101);
            boolean z = getBackground() == null;
            this.Px = z;
            if (z) {
                this.Pz.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c3c));
                textView = this.Py;
                i = -6513508;
            } else {
                this.Pz.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c3d));
                textView = this.Py;
                i = -1711276033;
            }
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.Pz.setImageDrawable(getContext().getResources().getDrawable(this.Px ? R.drawable.obfuscated_res_0x7f080c3c : R.drawable.obfuscated_res_0x7f080c3d));
        }
    }

    public final void T(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091100);
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            String str = this.Px ? bQ.adBaseInfo.adGrayMarkIcon : bQ.adBaseInfo.adMarkIcon;
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(bQ.adBaseInfo.adSourceDescription)) {
                this.Py.setVisibility(0);
                this.Py.setText(com.kwad.sdk.core.response.a.a.ak(bQ));
                this.Pz.setVisibility(0);
                qg();
                a aVar = this.PB;
            } else {
                if (TextUtils.isEmpty(bQ.adBaseInfo.adSourceDescription)) {
                    this.Py.setVisibility(8);
                    this.Py.setText("");
                } else {
                    this.Py.setText(com.kwad.sdk.core.response.a.a.ak(bQ));
                    this.Py.setVisibility(0);
                }
                if (TextUtils.isEmpty(str)) {
                    this.Pz.setVisibility(8);
                    this.Pz.setImageDrawable(null);
                } else {
                    KSImageLoader.loadFeeImage(this.Pz, str, adTemplate, this.PA);
                    this.Pz.setVisibility(0);
                }
            }
            findViewById.setVisibility(0);
        }
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.Pz : (ImageView) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Py : (TextView) invokeV.objValue;
    }

    public void setLogoLoadFinishListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.PB = aVar;
        }
    }
}
