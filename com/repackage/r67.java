package com.repackage;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.q67;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes7.dex */
public class r67 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r67 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public final q67 b;
    public final q67 c;
    public final q67 d;
    public CustomMessage<String> e;
    public BdUniqueId f;
    public CustomMessageListener g;

    /* loaded from: classes7.dex */
    public class a implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public a(r67 r67Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list};
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
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public b(r67 r67Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list};
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
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && (next.getIsFriend() == 0 || next.getIsFriend() == 3)) {
                        if (next.getShowOutOfStranger() == 0) {
                            this.a.add(next);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(r67 r67Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list};
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
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && (next.getIsFriend() == 1 || next.getIsFriend() == 2 || next.getShowOutOfStranger() == 1)) {
                        if (next.getIs_hidden() == 0) {
                            this.a.add(next);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public d(r67 r67Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && (next.getIsFriend() == 0 || next.getIsFriend() == 3)) {
                        if (next.getIs_hidden() == 0 && next.getShowOutOfStranger() == 0) {
                            if (this.a.getLast_content_time() < next.getLast_content_time()) {
                                this.a.setLast_content(next.getLast_content());
                                this.a.setLast_content_time(next.getLast_content_time());
                                this.a.setLast_rid(next.getLast_rid());
                                this.a.setLast_user_name(next.getLast_user_name());
                                this.a.setSend_status(next.getSend_status());
                            }
                            ImMessageCenterPojo imMessageCenterPojo = this.a;
                            imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                            this.a.setIs_hidden(0);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends sd5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public e(r67 r67Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // com.repackage.sd5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z57.f().k(this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public f(r67 r67Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                        if (this.a.getLast_content_time() < next.getLast_content_time()) {
                            this.a.setLast_content(next.getLast_content());
                            this.a.setLast_content_time(next.getLast_content_time());
                            this.a.setLast_rid(next.getLast_rid());
                            this.a.setLast_user_name(next.getLast_user_name());
                        }
                        this.a.setIs_hidden(0);
                        ImMessageCenterPojo imMessageCenterPojo = this.a;
                        imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(r67 r67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo.setCustomGroupType(-8);
                imMessageCenterPojo.setIs_hidden(1);
                z57.f().k(imMessageCenterPojo);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LongSparseArray a;
        public final /* synthetic */ r67 b;

        public h(r67 r67Var, LongSparseArray longSparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, longSparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r67Var;
            this.a = longSparseArray;
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (this.b.B(next)) {
                        this.a.put(kg.g(next.getGid(), 0L), Long.valueOf(z87.c(next.getPulled_msgId())));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ NewpushRepair.Builder b;

        public i(r67 r67Var, List list, NewpushRepair.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list, builder};
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
            this.b = builder;
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    long g = kg.g(next.getGid(), 0L);
                    long sid = next.getSid();
                    if (sid > 0) {
                        this.a.add(MessageUtils.makeNewpushGroupRepair(g, next.getUserType(), sid, 0L, z87.c(next.getPulled_msgId())));
                    }
                }
                if (this.a.size() <= 10) {
                    this.b.groups = this.a;
                    return;
                }
                this.b.followType = "0";
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(r67 r67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String data = customMessage.getData();
                v87.a("run MEMORY_GET_FROM_DB Task：" + data);
                d67.a();
                LinkedList<ImMessageCenterPojo> d = z57.f().d();
                v87.a("从" + data + ".db数据库中的tb_message_center表中获得所有数据List:");
                long c = i57.b().c(11L);
                long c2 = i57.b().c(12L);
                if (d == null) {
                    d = new LinkedList<>();
                }
                if (c != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    d.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(z87.a(c));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (c2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    d.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(z87.a(c2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(d, data);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r67 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(r67 r67Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r67Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                v87.a("onMessage MEMORY_GET_FROM_DB：mInitFromDBListener");
                e77.e().b();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (!TextUtils.isEmpty(uid) && uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    try {
                        for (ImMessageCenterPojo imMessageCenterPojo : memoryGetFromDBMessage.getData()) {
                            if (!this.a.B(imMessageCenterPojo) || imMessageCenterPojo.getPulled_msgId() > 0) {
                                if (kg.g(imMessageCenterPojo.getGid(), 0L) != 0) {
                                    if (imMessageCenterPojo.getCustomGroupType() == -9 && imMessageCenterPojo.getPushIds() != null && imMessageCenterPojo.getPushIds().length() > 0) {
                                        e77.e().j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getPushIds());
                                    }
                                    this.a.G(imMessageCenterPojo);
                                }
                            }
                        }
                        this.a.w(false);
                        this.a.r(false);
                        this.a.z();
                        this.a.y();
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    this.a.a.set(true);
                    this.a.N();
                    return;
                }
                List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                if (data != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : data) {
                        if (imMessageCenterPojo2 != null && s67.b(imMessageCenterPojo2.getCustomGroupType()) && imMessageCenterPojo2.getPulled_msgId() > 0) {
                            this.a.G(imMessageCenterPojo2);
                        }
                    }
                }
                this.a.a.set(true);
                this.a.N();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(r67 r67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(r67 r67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(r67 r67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public o(r67 r67Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list};
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
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public p(r67 r67Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list};
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
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public q(r67 r67Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list};
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
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements q67.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public r(r67 r67Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r67Var, list};
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
        }

        @Override // com.repackage.q67.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    public r67() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.b = new q67();
        this.c = new q67();
        this.d = new q67();
        this.g = new k(this, 2016008);
        MessageManager.getInstance().registerListener(this.g);
        this.e = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.e.setTag(gen);
    }

    public static r67 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (h == null) {
                synchronized (r67.class) {
                    if (h == null) {
                        h = new r67();
                    }
                }
            }
            return h;
        }
        return (r67) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.get() : invokeV.booleanValue;
    }

    public final boolean B(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            return s67.a(imMessageCenterPojo.getCustomGroupType());
        }
        return invokeL.booleanValue;
    }

    public void C(String str, int i2, boolean z) {
        ImMessageCenterPojo D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (D = D(str, i2, z)) == null) {
            return;
        }
        E(D, false);
    }

    public ImMessageCenterPojo D(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ImMessageCenterPojo j2 = j(str, i2);
            if (j2 != null) {
                if (z) {
                    j2.setIs_hidden(0);
                } else {
                    j2.setIs_hidden(1);
                }
            }
            return j2;
        }
        return (ImMessageCenterPojo) invokeCommon.objValue;
    }

    public final void E(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, imMessageCenterPojo, z) == null) && this.a.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                Q(imMessageCenterPojo, z, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                P(imMessageCenterPojo, z, 1);
            } else {
                M(imMessageCenterPojo, z, 1);
            }
        }
    }

    public final void F(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, imMessageCenterPojo) == null) && this.a.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                M(imMessageCenterPojo, false, 2);
                M(w(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                M(imMessageCenterPojo, false, 2);
                M(r(false), false, 1);
            } else {
                M(imMessageCenterPojo, false, 2);
            }
        }
    }

    public final void G(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, imMessageCenterPojo) == null) || imMessageCenterPojo == null) {
            return;
        }
        o(imMessageCenterPojo.getCustomGroupType()).a(imMessageCenterPojo);
    }

    public void H(String str, int i2) {
        ImMessageCenterPojo j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || (j2 = j(str, i2)) == null) {
            return;
        }
        I(str, i2);
        F(j2);
    }

    public void I(String str, int i2) {
        q67 o2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) && this.a.get() && (o2 = o(i2)) != null) {
            o2.e(str);
        }
    }

    public void J(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : list) {
            if (imMessageCenterPojo != null) {
                this.b.e(imMessageCenterPojo.getGid());
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a.get()) {
            this.b.d(new l(this));
            this.c.d(new m(this));
            this.d.d(new n(this));
            L();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016001));
        }
    }

    public void M(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i2));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            v87.a("sendInitCompletedMessage：发送内存初始化完成的消息");
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            M(r(false), false, 1);
        }
    }

    public final void P(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            M(imMessageCenterPojo, z, i2);
            M(r(z), z, i2);
        }
    }

    public void Q(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            M(imMessageCenterPojo, z, i2);
            M(w(z), z, i2);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            M(w(false), false, 1);
        }
    }

    public void S(String str, String str2) {
        ImMessageCenterPojo j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) || (j2 = j(str, 1)) == null) {
            return;
        }
        j2.setGroup_head(str2);
        E(j2, false);
    }

    public void T(String str, String str2) {
        ImMessageCenterPojo j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || (j2 = j(str, 1)) == null) {
            return;
        }
        j2.setGroup_name(str2);
        E(j2, false);
    }

    public void U(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, imMessageCenterPojo) == null) && this.a.get()) {
            ImMessageCenterPojo j2 = j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (j2 == null) {
                G(imMessageCenterPojo);
                E(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= j2.getLast_rid()) {
                I(j2.getGid(), j2.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(j2.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(j2.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(j2.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(j2.getBjhAvatar());
                }
                G(imMessageCenterPojo);
                E(imMessageCenterPojo, true);
            } else {
                j2.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    public void V(ImMessageCenterPojo imMessageCenterPojo, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048597, this, imMessageCenterPojo, i2) == null) && this.a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo j2 = j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (j2 == null) {
                imMessageCenterPojo.setUnread_count(i2);
                G(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                E(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > j2.getLast_rid()) {
                j2.setLast_rid(imMessageCenterPojo.getLast_rid());
                j2.setLast_content(imMessageCenterPojo.getLast_content());
                j2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                j2.setUnread_count(j2.getUnread_count() + i2);
                j2.setIs_hidden(0);
                j2.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                j2.setGroup_name(imMessageCenterPojo.getGroup_name());
                j2.setNameShow(imMessageCenterPojo.getNameShow());
                j2.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                E(j2, true);
            }
        }
    }

    public void W(int i2, long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str}) == null) && this.a.get()) {
            ImMessageCenterPojo j3 = j(str, i2);
            if (j3 == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i2);
                imMessageCenterPojo.setPulled_msgId(j2);
                imMessageCenterPojo.setGid(str);
                G(imMessageCenterPojo);
            } else if (j3.getPulled_msgId() < j2) {
                j3.setPulled_msgId(j2);
            }
        }
    }

    public void X(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, imMessageCenterPojo) == null) || !this.a.get() || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        ImMessageCenterPojo j2 = j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (j2 == null) {
            G(imMessageCenterPojo);
        } else if (j2.getPulled_msgId() > 0 || imMessageCenterPojo.getPulled_msgId() <= 0) {
        } else {
            j2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
        }
    }

    public void Y(int i2, ChatMessage chatMessage, String str, int i3) {
        int userType;
        ImMessageCenterPojo j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), chatMessage, str, Integer.valueOf(i3)}) == null) && this.a.get()) {
            UserData userData = null;
            if ((i2 == 2 || i2 == 4) && chatMessage != null) {
                if (String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                    userData = chatMessage.getToUserInfo();
                } else {
                    userData = chatMessage.getUserInfo();
                }
                if (userData != null) {
                    str = userData.getUserId();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ImMessageCenterPojo j3 = j(str, i2);
            if (j3 == null) {
                j3 = new ImMessageCenterPojo();
                j3.setCustomGroupType(i2);
                j3.setGid(str);
                G(j3);
            }
            if (i2 == 2 || i2 == 4) {
                if (userData != null) {
                    if (!TextUtils.isEmpty(userData.getPortrait())) {
                        j3.setGroup_head(userData.getPortrait());
                    }
                    if (!TextUtils.isEmpty(userData.getUserName())) {
                        j3.setGroup_name(userData.getUserName());
                    }
                    if (!TextUtils.isEmpty(userData.getName_show())) {
                        j3.setNameShow(userData.getName_show());
                    }
                    if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                        j3.setBjhAvatar(userData.getImBjhAvatar());
                    }
                }
                if (chatMessage != null) {
                    if (kg.g(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                        userType = chatMessage.getUserInfo().getUserType();
                    } else {
                        userType = chatMessage.getToUserInfo().getUserType();
                    }
                    j3.setUserType(userType);
                }
            }
            if (i3 == 1) {
                j3.setLast_content("");
                j3.setLast_rid(0L);
                j3.setSend_status(0);
                j3.setUnread_count(0);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (chatMessage != null && j3.getLast_rid() <= chatMessage.getRecordId()) {
                        j3.setLast_content_time(chatMessage.getTime() * 1000);
                        j3.setLast_content(a97.y(chatMessage.getMsgType(), chatMessage.getContent()));
                        j3.setLast_user_name(chatMessage.getUserInfo().getName_show());
                        j3.setLast_rid(chatMessage.getRecordId());
                        j3.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                        j3.setIsFriend(chatMessage.getIsFriend());
                        j3.setFollowStatus(chatMessage.getFollowStatus());
                        if (chatMessage.getLocalData() != null) {
                            j3.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                        }
                    }
                    j3.setIs_hidden(0);
                    j3.setShowOutOfStranger(1);
                    if (i2 == 4 && (j2 = j(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                        j2.setIs_hidden(0);
                    }
                }
            } else if (chatMessage != null) {
                j3.setLast_content_time(chatMessage.getTime() * 1000);
                j3.setLast_content(a97.y(chatMessage.getMsgType(), chatMessage.getContent()));
                j3.setLast_user_name(chatMessage.getUserInfo().getName_show());
                j3.setLast_rid(chatMessage.getRecordId());
                j3.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                j3.setIsFriend(chatMessage.getIsFriend());
                j3.setFollowStatus(chatMessage.getFollowStatus());
                if (chatMessage.getLocalData() != null) {
                    j3.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                }
            } else {
                j3.setLast_content("");
                j3.setLast_rid(0L);
                j3.setSend_status(0);
                j3.setUnread_count(0);
            }
            BdLog.i("send message status " + j3.getSend_status());
            E(j3, false);
        }
    }

    public void Z(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, imMessageCenterPojo) == null) && this.a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo j2 = j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (j2 == null) {
                G(imMessageCenterPojo);
                return;
            }
            j2.setGroup_head(imMessageCenterPojo.getGroup_head());
            j2.setGroup_name(imMessageCenterPojo.getGroup_name());
            j2.setNameShow(imMessageCenterPojo.getNameShow());
            j2.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    public void a0(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, imMessageCenterPojo) == null) {
            E(b0(imMessageCenterPojo), false);
        }
    }

    public ImMessageCenterPojo b0(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, imMessageCenterPojo)) == null) {
            if (this.a.get() && imMessageCenterPojo != null) {
                ImMessageCenterPojo j2 = j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
                if (j2 == null) {
                    G(imMessageCenterPojo);
                } else {
                    I(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
                    imMessageCenterPojo.setPulled_msgId(j2.getPulled_msgId());
                    G(imMessageCenterPojo);
                }
                return imMessageCenterPojo;
            }
            return null;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.b.b();
            this.c.b();
            this.d.b();
            L();
        }
    }

    public void i(String str, int i2) {
        ImMessageCenterPojo j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, str, i2) == null) || (j2 = j(str, i2)) == null) {
            return;
        }
        j2.setUnread_count(0);
        E(j2, false);
    }

    public ImMessageCenterPojo j(String str, int i2) {
        InterceptResult invokeLI;
        q67 o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i2)) == null) {
            if (this.a.get() && (o2 = o(i2)) != null) {
                return o2.c(str);
            }
            return null;
        }
        return (ImMessageCenterPojo) invokeLI.objValue;
    }

    public List<ImMessageCenterPojo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.b.d(new r(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.b.d(new o(this, linkedList));
            this.c.d(new p(this, linkedList));
            this.d.d(new q(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.d.d(new a(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.c.d(new b(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final q67 o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            if (i2 == 2) {
                return this.c;
            }
            if (i2 == 4) {
                return this.d;
            }
            return this.b;
        }
        return (q67) invokeI.objValue;
    }

    public long q(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048612, this, str, i2)) == null) {
            ImMessageCenterPojo j2 = j(str, i2);
            if (j2 != null) {
                return j2.getPulled_msgId();
            }
            return 0L;
        }
        return invokeLI.longValue;
    }

    public final ImMessageCenterPojo r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
            q67 o2 = o(-8);
            ImMessageCenterPojo c2 = o2 != null ? o2.c(TbEnum.CustomGroupId.OFFICIAL_MERGE) : null;
            if (c2 == null) {
                c2 = new ImMessageCenterPojo();
                c2.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                c2.setCustomGroupType(-8);
                G(c2);
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setIs_hidden(1);
            this.d.d(new f(this, imMessageCenterPojo));
            c2.setUserType(imMessageCenterPojo.getUserType());
            c2.setLast_content(imMessageCenterPojo.getLast_content());
            c2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
            c2.setLast_rid(imMessageCenterPojo.getLast_rid());
            c2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
            if (imMessageCenterPojo.getIs_hidden() == 1) {
                c2.setUnread_count(0);
                if (c2.getIs_hidden() != 1) {
                    c2.setIs_hidden(1);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new g(this));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            } else if (z) {
                if (ChatStatusManager.getInst().getIsOpen(4)) {
                    c2.setUnread_count(0);
                } else {
                    c2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
                    c2.setUnread_count(imMessageCenterPojo.getUnread_count());
                }
            } else if (c2.getUnread_count() > 0) {
                c2.setUnread_count(imMessageCenterPojo.getUnread_count());
            }
            return c2;
        }
        return (ImMessageCenterPojo) invokeZ.objValue;
    }

    public LongSparseArray<Long> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
            if (this.a.get()) {
                this.b.d(new h(this, longSparseArray));
            }
            return longSparseArray;
        }
        return (LongSparseArray) invokeV.objValue;
    }

    public NewpushRepair t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            NewpushRepair.Builder builder = new NewpushRepair.Builder();
            ArrayList arrayList = new ArrayList();
            if (this.a.get()) {
                this.d.d(new i(this, arrayList, builder));
            }
            return builder.build(false);
        }
        return (NewpushRepair) invokeV.objValue;
    }

    public long u(String str, int i2) {
        InterceptResult invokeLI;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048616, this, str, i2)) == null) {
            ImMessageCenterPojo j3 = j(str, i2);
            if (j3 != null) {
                j2 = j3.getLast_rid() > j3.getPulled_msgId() ? j3.getLast_rid() : j3.getPulled_msgId();
            } else {
                j2 = 0;
            }
            return j2 + 1;
        }
        return invokeLI.longValue;
    }

    public List<ImMessageCenterPojo> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.c.d(new c(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final ImMessageCenterPojo w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            q67 o2 = o(-7);
            ImMessageCenterPojo c2 = o2 != null ? o2.c(TbEnum.CustomGroupId.STRANGE_MERGE) : null;
            if (c2 == null) {
                c2 = new ImMessageCenterPojo();
                c2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                c2.setCustomGroupType(-7);
                G(c2);
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setIs_hidden(1);
            this.c.d(new d(this, imMessageCenterPojo));
            c2.setLast_content(imMessageCenterPojo.getLast_content());
            c2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
            c2.setLast_rid(imMessageCenterPojo.getLast_rid());
            c2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
            c2.setSend_status(imMessageCenterPojo.getSend_status());
            if (imMessageCenterPojo.getIs_hidden() == 1) {
                c2.setUnread_count(0);
                if (c2.getIs_hidden() != 1) {
                    c2.setIs_hidden(1);
                    ImMessageCenterPojo j2 = j(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                    if (j2 != null) {
                        vd5.c(new e(this, j2), null);
                    }
                }
            } else {
                if (z) {
                    if (ChatStatusManager.getInst().getIsOpen(5)) {
                        c2.setUnread_count(0);
                    } else {
                        c2.setUnread_count(imMessageCenterPojo.getUnread_count());
                    }
                } else if (c2.getUnread_count() > 0) {
                    c2.setUnread_count(imMessageCenterPojo.getUnread_count());
                }
                c2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
            }
            return c2;
        }
        return (ImMessageCenterPojo) invokeZ.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.a.set(false);
            h();
            MessageManager.getInstance().removeMessage(2016008, this.f);
            this.e.setData(TbadkCoreApplication.getCurrentAccount());
            CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new j(this));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            v87.a("ImMemoryCacheManager.getInstance().init()");
            MessageManager.getInstance().sendMessage(this.e, customMessageTask);
        }
    }

    public final void y() {
        q67 o2;
        ImMessageCenterPojo c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (o2 = o(-3)) == null || (c2 = o2.c(TbEnum.CustomGroupId.GROUP_UPDATE)) == null) {
            return;
        }
        String last_content = c2.getLast_content();
        if (TextUtils.isEmpty(last_content)) {
            return;
        }
        try {
            c2.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public final void z() {
        q67 o2;
        ImMessageCenterPojo c2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (o2 = o(-4)) == null || (c2 = o2.c(TbEnum.CustomGroupId.GROUP_VALIDATION)) == null) {
            return;
        }
        String last_content = c2.getLast_content();
        if (TextUtils.isEmpty(last_content)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(last_content);
            JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            String str3 = "";
            if (true != jSONObject.isNull("notice_id")) {
                str3 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                str = optString;
                str2 = optString2;
            } else if (optJSONObject != null) {
                str3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                str = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                str2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
            } else {
                str2 = "";
                str = str2;
            }
            ImMessageCenterPojo c3 = this.b.c(str3);
            if (c3 != null) {
                str2 = c3.getGroup_name();
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            c2.setLast_content(str + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f14e6) + str2);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
