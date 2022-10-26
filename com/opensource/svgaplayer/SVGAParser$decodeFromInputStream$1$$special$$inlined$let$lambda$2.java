package com.opensource.svgaplayer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$1$2$1", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 13}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2 extends Lambda implements Function0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ SVGAVideoEntity $videoItem;
    public final /* synthetic */ SVGAParser$decodeFromInputStream$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(SVGAVideoEntity sVGAVideoEntity, SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVGAVideoEntity, sVGAParser$decodeFromInputStream$1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$videoItem = sVGAVideoEntity;
        this.this$0 = sVGAParser$decodeFromInputStream$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1 = this.this$0;
            sVGAParser$decodeFromInputStream$1.a.s(this.$videoItem, sVGAParser$decodeFromInputStream$1.d);
        }
    }
}
