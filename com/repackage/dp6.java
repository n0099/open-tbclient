package com.repackage;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class dp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public a(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J0();
            }
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, id6 id6Var, FrsViewData frsViewData) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, responsedMessage, id6Var, frsViewData) == null) || frsViewData == null || id6Var == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
            return;
        }
        boolean z = false;
        Iterator<DownloadData> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getStatus() == 0) {
                z = true;
                break;
            }
        }
        if (z) {
            qg.a().postDelayed(new a(id6Var), TimeUnit.SECONDS.toMillis(2L));
        }
    }

    public static void b(id6 id6Var) {
        HashMap<Integer, ThreadData> h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, id6Var) == null) || id6Var == null || id6Var.X() == null || (h = id6Var.X().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, ThreadData> entry : h.entrySet()) {
            ThreadData value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        ha8.n().w(arrayList);
    }
}
