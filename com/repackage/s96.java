package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class s96 {
    public static /* synthetic */ Interceptable $ic;
    public static s96 b;
    public transient /* synthetic */ FieldHolder $fh;
    public GetEmotionInfosModel a;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ s96 d;

        public a(s96 s96Var, l lVar, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, lVar, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s96Var;
            this.a = lVar;
            this.b = list;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? Integer.valueOf(e96.k().i(TbadkCoreApplication.getCurrentAccount()) - 1) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                if (num.intValue() >= 300) {
                    l lVar = this.a;
                    if (lVar != null) {
                        lVar.onResult(4, 0, 0);
                        return;
                    } else {
                        oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1068);
                        return;
                    }
                }
                while (this.b.size() + num.intValue() > 300) {
                    List list = this.b;
                    list.remove(list.size() - 1);
                }
                this.d.i(this.b, this.c, this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements GetEmotionInfosModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ List c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ s96 e;

        public b(s96 s96Var, l lVar, Map map, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, lVar, map, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s96Var;
            this.a = lVar;
            this.b = map;
            this.c = list;
            this.d = z;
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                l lVar = this.a;
                if (lVar == null) {
                    oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1067);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<l35> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    l lVar = this.a;
                    if (lVar == null) {
                        oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1067);
                    } else {
                        lVar.onResult(4, 0, 0);
                    }
                }
                for (l35 l35Var : list) {
                    if (!t96.e().f(l35Var.a)) {
                        l35Var.f = (String) this.b.get(l35Var.g);
                        this.c.add(l35Var);
                    }
                }
                this.e.m(this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l35 b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ l d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ s96 f;

        public c(s96 s96Var, List list, l35 l35Var, AtomicInteger atomicInteger, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, list, l35Var, atomicInteger, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s96Var;
            this.a = list;
            this.b = l35Var;
            this.c = atomicInteger;
            this.d = lVar;
            this.e = z;
        }

        @Override // com.repackage.s96.j
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.decrementAndGet() == 0) {
                this.f.f(this.a, this.d, this.e);
            }
        }

        @Override // com.repackage.s96.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.add(this.f.w(this.b));
                if (this.c.decrementAndGet() == 0) {
                    this.f.f(this.a, this.d, this.e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public d(s96 s96Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = lVar;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? Boolean.valueOf(e96.k().b(this.a)) : (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    l lVar = this.b;
                    if (lVar == null) {
                        oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00cf);
                    } else {
                        lVar.onResult(4, 1, 0);
                    }
                    t96.e().g();
                    if (this.c) {
                        new UserCollectModel().y();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    TiebaStatic.log("c12222");
                    return;
                }
                l lVar2 = this.b;
                if (lVar2 == null) {
                    oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1067);
                } else {
                    lVar2.onResult(4, 0, 0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public e(s96 s96Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = lVar;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> n = e96.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashMap hashMap = new HashMap();
                for (CollectEmotionData collectEmotionData : n) {
                    hashMap.put(collectEmotionData.getSharpText(), collectEmotionData);
                }
                int size = n.size() - 2;
                for (int i = 0; i < this.a.size(); i++) {
                    CollectEmotionData collectEmotionData2 = (CollectEmotionData) this.a.get(i);
                    collectEmotionData2.orderId = size;
                    String sharpText = collectEmotionData2.getSharpText();
                    if (hashMap.containsKey(sharpText)) {
                        n.remove(hashMap.get(sharpText));
                        hashMap.remove(sharpText);
                    }
                    e96.k().r(collectEmotionData2);
                    size--;
                }
                for (int i2 = 0; i2 < n.size(); i2++) {
                    CollectEmotionData collectEmotionData3 = n.get(i2);
                    if (!i35.d.equals(collectEmotionData3.sharpText)) {
                        collectEmotionData3.orderId = size;
                        e96.k().r(collectEmotionData3);
                        size--;
                    }
                }
                if (this.a.size() > 0) {
                    t96.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this.a.size()));
                arrayList.add(0);
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || list == null || list.size() != 2) {
                return;
            }
            this.b.onResult(2, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.c) {
                    new UserCollectModel().y();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12227");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public f(s96 s96Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = lVar;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i = 0;
                for (CollectEmotionData collectEmotionData : this.a) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !i35.d.equals(collectEmotionData.sharpText)) {
                        e96.k().g(collectEmotionData);
                        ImageFileInfo imageFileInfo = collectEmotionData.imageFileInfo;
                        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                            File file = new File(collectEmotionData.imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                            String filePath = collectEmotionData.imageFileInfo.getFilePath();
                            File file2 = new File(filePath.replace("_s.jpg", "_b.jpg"));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            File file3 = new File(filePath.replace("_s.jpg", "_b.gif"));
                            if (file3.exists()) {
                                file3.delete();
                            }
                        }
                        i++;
                    }
                }
                List<CollectEmotionData> n = e96.k().n(TbadkCoreApplication.getCurrentAccount());
                for (int i2 = 0; i2 < n.size(); i2++) {
                    CollectEmotionData collectEmotionData2 = n.get(i2);
                    if (!i35.d.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.orderId = (n.size() - i2) - 1;
                        e96.k().r(collectEmotionData2);
                    }
                }
                if (i > 0) {
                    t96.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i));
                arrayList.add(Integer.valueOf(this.a.size() - i));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || list == null || list.size() != 2) {
                return;
            }
            this.b.onResult(1, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.c) {
                    new UserCollectModel().y();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12226");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ s96 c;

        public g(s96 s96Var, List list, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, list, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s96Var;
            this.a = list;
            this.b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i = 0;
                for (CollectEmotionData collectEmotionData : this.a) {
                    String filePath = collectEmotionData.imageFileInfo.getFilePath();
                    File file = new File(filePath.replace("_s.jpg", "_b.jpg"));
                    byte[] r = file.exists() ? this.c.r(file) : null;
                    if (r == null) {
                        r = this.c.r(new File(filePath.replace("_s.jpg", "_b.gif")));
                    }
                    if (r != null && FileHelper.saveImageFileByUser(collectEmotionData.picUrl, r, TbadkCoreApplication.getInst().getContext()) == 0) {
                        i++;
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i));
                arrayList.add(Integer.valueOf(this.a.size() - i));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || list == null || list.size() != 2) {
                return;
            }
            this.b.onResult(3, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                StatisticItem statisticItem = new StatisticItem("c12228");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s96 a;

        public h(s96 s96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s96Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? this.a.p() : (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
                return;
            }
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null) {
                    l35 l35Var = new l35();
                    l35Var.a = collectEmotionData.pid;
                    l35Var.f = collectEmotionData.pkgId;
                    l35Var.d = collectEmotionData.picUrl;
                    l35Var.e = collectEmotionData.thumbnail;
                    l35Var.b = collectEmotionData.width;
                    l35Var.c = collectEmotionData.height;
                    new k(this.a, null).execute(l35Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(s96 s96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.s96.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public class k extends BdAsyncTask<l35, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public l35 a;
        public j b;
        public final /* synthetic */ s96 c;

        public k(s96 s96Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s96Var, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s96Var;
            this.b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(l35[] l35VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l35VarArr)) == null) {
                if (l35VarArr != null && l35VarArr.length > 0) {
                    this.a = l35VarArr[0];
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(this.a.d, false);
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        String q = this.c.q(this.a, true);
                        if (TextUtils.isEmpty(q)) {
                            return Boolean.FALSE;
                        }
                        if (oi.A(downloadImageBytes)) {
                            q = q.replace("_b.jpg", "_b.gif");
                        }
                        File file = new File(q);
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (!this.c.u(file, downloadImageBytes)) {
                            return Boolean.FALSE;
                        }
                        byte[] downloadImageBytes2 = webClient.downloadImageBytes(this.a.e, false);
                        if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                            String q2 = this.c.q(this.a, false);
                            if (!TextUtils.isEmpty(q2)) {
                                if (!this.c.u(new File(q2), downloadImageBytes2)) {
                                    return Boolean.FALSE;
                                }
                                return Boolean.TRUE;
                            }
                            return Boolean.FALSE;
                        }
                        return Boolean.FALSE;
                    }
                    return Boolean.FALSE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    j jVar = this.b;
                    if (jVar != null) {
                        jVar.onSuccess();
                        return;
                    }
                    return;
                }
                j jVar2 = this.b;
                if (jVar2 != null) {
                    jVar2.onFail();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface l {
        void onResult(int i, int i2, int i3);
    }

    public s96() {
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

    public static String o(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + i35.b() + "/" + str + "_s.jpg";
            if (z) {
                String replace = str2.replace("_s.jpg", "_b.jpg");
                if (new File(replace).exists()) {
                    return replace;
                }
                String replace2 = str2.replace("_s.jpg", "_b.gif");
                return new File(replace2).exists() ? replace2 : "";
            }
            return str2;
        }
        return (String) invokeLZ.objValue;
    }

    public static s96 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                b = new s96();
            }
            return b;
        }
        return (s96) invokeV.objValue;
    }

    public final void f(List<CollectEmotionData> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, list, lVar, z) == null) {
            new d(this, list, lVar, z).execute(new Void[0]);
        }
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (bo7.m().n()) {
                oi.M(BdBaseApplication.getInst().getApp(), R.string.obfuscated_res_0x7f0f05cf);
                return;
            }
            l35 l35Var = new l35();
            l35Var.d = str;
            l35Var.f = str2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(l35Var);
            h(arrayList, true, null);
        }
    }

    public void h(List<l35> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            new a(this, lVar, list, z).execute(new Void[0]);
        }
    }

    public void i(List<l35> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list == null || list.isEmpty()) {
                if (lVar == null) {
                    oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1067);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            } else if (TbadkCoreApplication.isLogin()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                for (l35 l35Var : list) {
                    String str = l35Var.a;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        if (!t96.e().f(l35Var.a)) {
                            arrayList.add(l35Var);
                        }
                    } else {
                        arrayList2.add(l35Var.d);
                        String str2 = l35Var.f;
                        if (str2 != null) {
                            hashMap.put(l35Var.d, str2);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    if (this.a == null) {
                        this.a = new GetEmotionInfosModel();
                    }
                    this.a.A(arrayList2, new b(this, lVar, hashMap, arrayList, z));
                    return;
                }
                m(arrayList, lVar, z);
            } else if (lVar == null) {
                ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
            } else {
                lVar.onResult(4, 0, 0);
            }
        }
    }

    public void j(List<String> list, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, lVar) == null) {
            if (ListUtils.isEmpty(list) && lVar != null) {
                lVar.onResult(4, 0, 0);
            }
            if (bo7.m().n()) {
                oi.M(BdBaseApplication.getInst().getApp(), R.string.obfuscated_res_0x7f0f05cf);
                lVar.onResult(4, 0, 0);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                l35 l35Var = new l35();
                l35Var.d = str;
                arrayList.add(l35Var);
            }
            h(arrayList, true, lVar);
        }
    }

    public boolean k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            List<CollectEmotionData> p = p();
            if (p == null || p.isEmpty()) {
                return true;
            }
            if (z) {
                l(p, false, new i(this));
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void l(List<CollectEmotionData> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && list.size() > 0) {
                new f(this, list, lVar, z).execute(new Void[0]);
            } else if (lVar != null) {
                lVar.onResult(1, 1, 0);
            }
        }
    }

    public final void m(List<l35> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, list, lVar, z) == null) {
            if (list.size() == 0) {
                if (lVar == null) {
                    oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00cf);
                    return;
                } else {
                    lVar.onResult(4, 1, 0);
                    return;
                }
            }
            AtomicInteger atomicInteger = new AtomicInteger(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (l35 l35Var : list) {
                new k(this, new c(this, copyOnWriteArrayList, l35Var, atomicInteger, lVar, z)).execute(l35Var);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            new h(this).execute(new Void[0]);
        }
    }

    public List<CollectEmotionData> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<CollectEmotionData> n = e96.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
            if (n != null) {
                for (CollectEmotionData collectEmotionData : n) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !new File(o(collectEmotionData.pid, false)).exists()) {
                        arrayList.add(collectEmotionData);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final String q(l35 l35Var, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, l35Var, z)) == null) {
            if (l35Var == null || TextUtils.isEmpty(l35Var.d) || TextUtils.isEmpty(l35Var.a)) {
                return "";
            }
            if (z) {
                str = "_b.jpg";
            } else {
                str = "_s.jpg";
            }
            return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + i35.b() + "/" + l35Var.a + str;
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    public byte[] r(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, file)) == null) {
            InputStream inputStream = null;
            if (file != null) {
                ?? exists = file.exists();
                try {
                    if (exists != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, 1024);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        pi.e(fileInputStream);
                                        return byteArray;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                                BdLog.e(e.getMessage());
                                pi.e(fileInputStream);
                                return null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            pi.e(inputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = exists;
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public void t(List<CollectEmotionData> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && list.size() > 0) {
                new e(this, list, lVar, z).execute(new Void[0]);
            } else if (lVar != null) {
                lVar.onResult(2, 0, 0);
            }
        }
    }

    public final boolean u(File file, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048589, this, file, bArr)) != null) {
            return invokeLL.booleanValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if ((!file.exists() || file.delete()) && file.createNewFile()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr, 0, bArr.length);
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            BdLog.e(e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    BdLog.e(th2.getMessage());
                    return false;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void v(List<CollectEmotionData> list, l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, list, lVar) == null) || list == null || list.size() <= 0) {
            return;
        }
        new g(this, list, lVar).execute(new Void[0]);
    }

    public final CollectEmotionData w(l35 l35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, l35Var)) == null) {
            CollectEmotionData collectEmotionData = new CollectEmotionData();
            StringBuilder sb = new StringBuilder(i35.f);
            if (TextUtils.isEmpty(l35Var.f)) {
                sb.append(l35Var.a);
                sb.append(",");
            } else {
                sb.append(l35Var.f);
                sb.append("_");
                sb.append(l35Var.a);
                sb.append(",");
            }
            sb.append(l35Var.b);
            sb.append(",");
            sb.append(l35Var.c);
            sb.append(",");
            String lowerCase = ui.c(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase();
            collectEmotionData.pid = l35Var.a;
            collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
            collectEmotionData.sharpText = SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX;
            collectEmotionData.orderId = e96.k().i(collectEmotionData.uid) + 1;
            collectEmotionData.width = l35Var.b;
            collectEmotionData.height = l35Var.c;
            collectEmotionData.picUrl = l35Var.d;
            collectEmotionData.thumbnail = l35Var.e;
            collectEmotionData.backup = "";
            return collectEmotionData;
        }
        return (CollectEmotionData) invokeL.objValue;
    }
}
