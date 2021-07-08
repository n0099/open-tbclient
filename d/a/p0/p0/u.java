package d.a.p0.p0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes8.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static u f61273b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GetEmotionInfosModel f61274a;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f61275a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f61276b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f61277c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ u f61278d;

        public a(u uVar, l lVar, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, lVar, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61278d = uVar;
            this.f61275a = lVar;
            this.f61276b = list;
            this.f61277c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? Integer.valueOf(d.a.p0.p0.g.k().i(TbadkCoreApplication.getCurrentAccount()) - 1) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                if (num.intValue() >= 300) {
                    l lVar = this.f61275a;
                    if (lVar != null) {
                        lVar.onResult(4, 0, 0);
                        return;
                    } else {
                        d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_limit);
                        return;
                    }
                }
                while (this.f61276b.size() + num.intValue() > 300) {
                    List list = this.f61276b;
                    list.remove(list.size() - 1);
                }
                this.f61278d.i(this.f61276b, this.f61277c, this.f61275a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements GetEmotionInfosModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f61279a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f61280b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f61281c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f61282d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f61283e;

        public b(u uVar, l lVar, Map map, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, lVar, map, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61283e = uVar;
            this.f61279a = lVar;
            this.f61280b = map;
            this.f61281c = list;
            this.f61282d = z;
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                l lVar = this.f61279a;
                if (lVar == null) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<d.a.o0.b0.c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    l lVar = this.f61279a;
                    if (lVar == null) {
                        d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                    } else {
                        lVar.onResult(4, 0, 0);
                    }
                }
                for (d.a.o0.b0.c cVar : list) {
                    if (!v.e().f(cVar.f51532a)) {
                        cVar.f51537f = (String) this.f61280b.get(cVar.f51538g);
                        this.f61281c.add(cVar);
                    }
                }
                this.f61283e.m(this.f61281c, this.f61279a, this.f61282d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f61284a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.b0.c f61285b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f61286c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l f61287d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f61288e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u f61289f;

        public c(u uVar, List list, d.a.o0.b0.c cVar, AtomicInteger atomicInteger, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, list, cVar, atomicInteger, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61289f = uVar;
            this.f61284a = list;
            this.f61285b = cVar;
            this.f61286c = atomicInteger;
            this.f61287d = lVar;
            this.f61288e = z;
        }

        @Override // d.a.p0.p0.u.j
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61286c.decrementAndGet() == 0) {
                this.f61289f.f(this.f61284a, this.f61287d, this.f61288e);
            }
        }

        @Override // d.a.p0.p0.u.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f61284a.add(this.f61289f.w(this.f61285b));
                if (this.f61286c.decrementAndGet() == 0) {
                    this.f61289f.f(this.f61284a, this.f61287d, this.f61288e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f61290a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f61291b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f61292c;

        public d(u uVar, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61290a = list;
            this.f61291b = lVar;
            this.f61292c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? Boolean.valueOf(d.a.p0.p0.g.k().b(this.f61290a)) : (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    l lVar = this.f61291b;
                    if (lVar == null) {
                        d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.add_success);
                    } else {
                        lVar.onResult(4, 1, 0);
                    }
                    v.e().g();
                    if (this.f61292c) {
                        new UserCollectModel().w();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    TiebaStatic.log("c12222");
                    return;
                }
                l lVar2 = this.f61291b;
                if (lVar2 == null) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar2.onResult(4, 0, 0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f61293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f61294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f61295c;

        public e(u uVar, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61293a = list;
            this.f61294b = lVar;
            this.f61295c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> n = d.a.p0.p0.g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashMap hashMap = new HashMap();
                for (CollectEmotionData collectEmotionData : n) {
                    hashMap.put(collectEmotionData.getSharpText(), collectEmotionData);
                }
                int size = n.size() - 2;
                for (int i2 = 0; i2 < this.f61293a.size(); i2++) {
                    CollectEmotionData collectEmotionData2 = (CollectEmotionData) this.f61293a.get(i2);
                    collectEmotionData2.orderId = size;
                    String sharpText = collectEmotionData2.getSharpText();
                    if (hashMap.containsKey(sharpText)) {
                        n.remove(hashMap.get(sharpText));
                        hashMap.remove(sharpText);
                    }
                    d.a.p0.p0.g.k().r(collectEmotionData2);
                    size--;
                }
                for (int i3 = 0; i3 < n.size(); i3++) {
                    CollectEmotionData collectEmotionData3 = n.get(i3);
                    if (!d.a.o0.a0.d.f51435d.equals(collectEmotionData3.sharpText)) {
                        collectEmotionData3.orderId = size;
                        d.a.p0.p0.g.k().r(collectEmotionData3);
                        size--;
                    }
                }
                if (this.f61293a.size() > 0) {
                    v.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this.f61293a.size()));
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f61294b == null || list == null || list.size() != 2) {
                return;
            }
            this.f61294b.onResult(2, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.f61295c) {
                    new UserCollectModel().w();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12227");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f61296a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f61297b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f61298c;

        public f(u uVar, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61296a = list;
            this.f61297b = lVar;
            this.f61298c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i2 = 0;
                for (CollectEmotionData collectEmotionData : this.f61296a) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !d.a.o0.a0.d.f51435d.equals(collectEmotionData.sharpText)) {
                        d.a.p0.p0.g.k().g(collectEmotionData);
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
                        i2++;
                    }
                }
                List<CollectEmotionData> n = d.a.p0.p0.g.k().n(TbadkCoreApplication.getCurrentAccount());
                for (int i3 = 0; i3 < n.size(); i3++) {
                    CollectEmotionData collectEmotionData2 = n.get(i3);
                    if (!d.a.o0.a0.d.f51435d.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.orderId = (n.size() - i3) - 1;
                        d.a.p0.p0.g.k().r(collectEmotionData2);
                    }
                }
                if (i2 > 0) {
                    v.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(this.f61296a.size() - i2));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f61297b == null || list == null || list.size() != 2) {
                return;
            }
            this.f61297b.onResult(1, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.f61298c) {
                    new UserCollectModel().w();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12226");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f61299a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f61300b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ u f61301c;

        public g(u uVar, List list, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, list, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61301c = uVar;
            this.f61299a = list;
            this.f61300b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i2 = 0;
                for (CollectEmotionData collectEmotionData : this.f61299a) {
                    String filePath = collectEmotionData.imageFileInfo.getFilePath();
                    File file = new File(filePath.replace("_s.jpg", "_b.jpg"));
                    byte[] r = file.exists() ? this.f61301c.r(file) : null;
                    if (r == null) {
                        r = this.f61301c.r(new File(filePath.replace("_s.jpg", "_b.gif")));
                    }
                    if (r != null && FileHelper.saveImageFileByUser(collectEmotionData.picUrl, r, TbadkCoreApplication.getInst().getContext()) == 0) {
                        i2++;
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(this.f61299a.size() - i2));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f61300b == null || list == null || list.size() != 2) {
                return;
            }
            this.f61300b.onResult(3, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                StatisticItem statisticItem = new StatisticItem("c12228");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f61302a;

        public h(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61302a = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? this.f61302a.p() : (List) invokeL.objValue;
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
                    d.a.o0.b0.c cVar = new d.a.o0.b0.c();
                    cVar.f51532a = collectEmotionData.pid;
                    cVar.f51537f = collectEmotionData.pkgId;
                    cVar.f51535d = collectEmotionData.picUrl;
                    cVar.f51536e = collectEmotionData.thumbnail;
                    cVar.f51533b = collectEmotionData.width;
                    cVar.f51534c = collectEmotionData.height;
                    new k(this.f61302a, null).execute(cVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.p0.p0.u.l
        public void onResult(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public class k extends BdAsyncTask<d.a.o0.b0.c, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.o0.b0.c f61303a;

        /* renamed from: b  reason: collision with root package name */
        public j f61304b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ u f61305c;

        public k(u uVar, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61305c = uVar;
            this.f61304b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(d.a.o0.b0.c[] cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr != null && cVarArr.length > 0) {
                    this.f61303a = cVarArr[0];
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(this.f61303a.f51535d, false);
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        String q = this.f61305c.q(this.f61303a, true);
                        if (TextUtils.isEmpty(q)) {
                            return Boolean.FALSE;
                        }
                        if (d.a.c.e.p.l.B(downloadImageBytes)) {
                            q = q.replace("_b.jpg", "_b.gif");
                        }
                        File file = new File(q);
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (!this.f61305c.u(file, downloadImageBytes)) {
                            return Boolean.FALSE;
                        }
                        byte[] downloadImageBytes2 = webClient.downloadImageBytes(this.f61303a.f51536e, false);
                        if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                            String q2 = this.f61305c.q(this.f61303a, false);
                            if (!TextUtils.isEmpty(q2)) {
                                if (!this.f61305c.u(new File(q2), downloadImageBytes2)) {
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
                    j jVar = this.f61304b;
                    if (jVar != null) {
                        jVar.onSuccess();
                        return;
                    }
                    return;
                }
                j jVar2 = this.f61304b;
                if (jVar2 != null) {
                    jVar2.onFail();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface l {
        void onResult(int i2, int i3, int i4);
    }

    public u() {
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
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z)) == null) {
            String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.a.o0.a0.d.b() + "/" + str + "_s.jpg";
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

    public static u s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f61273b == null) {
                f61273b = new u();
            }
            return f61273b;
        }
        return (u) invokeV.objValue;
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
            if (d.a.p0.c2.d.m().n()) {
                d.a.c.e.p.l.L(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
                return;
            }
            d.a.o0.b0.c cVar = new d.a.o0.b0.c();
            cVar.f51535d = str;
            cVar.f51537f = str2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            h(arrayList, true, null);
        }
    }

    public void h(List<d.a.o0.b0.c> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            new a(this, lVar, list, z).execute(new Void[0]);
        }
    }

    public void i(List<d.a.o0.b0.c> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list == null || list.isEmpty()) {
                if (lVar == null) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            } else if (TbadkCoreApplication.isLogin()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                for (d.a.o0.b0.c cVar : list) {
                    String str = cVar.f51532a;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        if (!v.e().f(cVar.f51532a)) {
                            arrayList.add(cVar);
                        }
                    } else {
                        arrayList2.add(cVar.f51535d);
                        String str2 = cVar.f51537f;
                        if (str2 != null) {
                            hashMap.put(cVar.f51535d, str2);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    if (this.f61274a == null) {
                        this.f61274a = new GetEmotionInfosModel();
                    }
                    this.f61274a.y(arrayList2, new b(this, lVar, hashMap, arrayList, z));
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
            if (d.a.p0.c2.d.m().n()) {
                d.a.c.e.p.l.L(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
                lVar.onResult(4, 0, 0);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                d.a.o0.b0.c cVar = new d.a.o0.b0.c();
                cVar.f51535d = str;
                arrayList.add(cVar);
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

    public final void m(List<d.a.o0.b0.c> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, list, lVar, z) == null) {
            if (list.size() == 0) {
                if (lVar == null) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.add_success);
                    return;
                } else {
                    lVar.onResult(4, 1, 0);
                    return;
                }
            }
            AtomicInteger atomicInteger = new AtomicInteger(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (d.a.o0.b0.c cVar : list) {
                new k(this, new c(this, copyOnWriteArrayList, cVar, atomicInteger, lVar, z)).execute(cVar);
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
            List<CollectEmotionData> n = d.a.p0.p0.g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
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

    public final String q(d.a.o0.b0.c cVar, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, cVar, z)) == null) {
            if (cVar == null || TextUtils.isEmpty(cVar.f51535d) || TextUtils.isEmpty(cVar.f51532a)) {
                return "";
            }
            if (z) {
                str = "_b.jpg";
            } else {
                str = "_s.jpg";
            }
            return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.a.o0.a0.d.b() + "/" + cVar.f51532a + str;
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
                                        d.a.c.e.p.m.e(fileInputStream);
                                        return byteArray;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                                BdLog.e(e.getMessage());
                                d.a.c.e.p.m.e(fileInputStream);
                                return null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            d.a.c.e.p.m.e(inputStream);
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

    public final CollectEmotionData w(d.a.o0.b0.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cVar)) == null) {
            CollectEmotionData collectEmotionData = new CollectEmotionData();
            StringBuilder sb = new StringBuilder(d.a.o0.a0.d.f51437f);
            if (TextUtils.isEmpty(cVar.f51537f)) {
                sb.append(cVar.f51532a);
                sb.append(",");
            } else {
                sb.append(cVar.f51537f);
                sb.append("_");
                sb.append(cVar.f51532a);
                sb.append(",");
            }
            sb.append(cVar.f51533b);
            sb.append(",");
            sb.append(cVar.f51534c);
            sb.append(",");
            String lowerCase = d.a.c.e.p.q.c(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase();
            collectEmotionData.pid = cVar.f51532a;
            collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
            collectEmotionData.sharpText = SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX;
            collectEmotionData.orderId = d.a.p0.p0.g.k().i(collectEmotionData.uid) + 1;
            collectEmotionData.width = cVar.f51533b;
            collectEmotionData.height = cVar.f51534c;
            collectEmotionData.picUrl = cVar.f51535d;
            collectEmotionData.thumbnail = cVar.f51536e;
            collectEmotionData.backup = "";
            return collectEmotionData;
        }
        return (CollectEmotionData) invokeL.objValue;
    }
}
