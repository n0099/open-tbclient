package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tieba.frs.voiceroom.VoiceRoomListActivity;
import com.baidu.tieba.frs.voiceroom.VoiceRoomStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class if6 extends uc1<x65> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements x65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.x65
        public void a(TbPageContext<?> tbPageContext, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, tbPageContext, j) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                d(tbPageContext, Intrinsics.stringPlus("bdtiebalive://video/mixlive?room_id=", Long.valueOf(j)));
            }
        }

        @Override // com.repackage.x65
        public void b(Context context, Frs$From from, Long l, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, from, l, str) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(from, "from");
                VoiceRoomListActivity.a.a(context, from, l, str);
            }
        }

        @Override // com.repackage.x65
        public void c(Long l, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, l, str) == null) {
                VoiceRoomStat.d(l, str);
            }
        }

        public void d(TbPageContext<?> tbPageContext, String scheme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, scheme) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{scheme});
            }
        }
    }

    public if6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uc1
    /* renamed from: a */
    public x65 createService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (x65) invokeV.objValue;
    }
}
