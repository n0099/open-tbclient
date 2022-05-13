package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class wn7 implements ro {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public int e;
    public int f;
    public boolean g;
    public ThreadData h;

    public wn7(ThreadInfo threadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadInfo, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(threadInfo);
        this.g = z;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : invokeV.intValue;
    }

    public final void b(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        ThreadData threadData = new ThreadData();
        this.h = threadData;
        threadData.parserProtobuf(threadInfo);
        this.a = threadInfo.title;
        this.b = threadInfo.reply_num.intValue();
        this.c = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.h.getMedias())) {
            Iterator<MediaData> it = this.h.getMedias().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.d = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.d = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.d)) {
                        this.d = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.d)) {
                        this.d = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.d)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.e = videoInfo.video_duration.intValue();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f = i;
        }
    }

    @Override // com.repackage.ro
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? vn7.a : (BdUniqueId) invokeV.objValue;
    }
}
