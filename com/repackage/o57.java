package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class o57 extends n57 {
    public static /* synthetic */ Interceptable $ic;
    public static o57 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ o57 d;

        public a(o57 o57Var, String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o57Var, str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o57Var;
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                GroupSettingItemData a = this.d.a(this.a, this.b);
                if (a != null && a.isAlreadyApply()) {
                    if (System.currentTimeMillis() - a.getLastApplyTimeStamp() <= this.c) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends mc5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupSettingItemData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ o57 c;

        public b(o57 o57Var, GroupSettingItemData groupSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o57Var, groupSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o57Var;
            this.a = groupSettingItemData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mc5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.b().g(this.b, OrmObject.jsonStrWithObject(this.a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends mc5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ o57 b;

        public c(o57 o57Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o57Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o57Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mc5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.b.b().remove(this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755488640, "Lcom/repackage/o57;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755488640, "Lcom/repackage/o57;");
                return;
            }
        }
        b = new o57();
    }

    public o57() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static o57 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (o57) invokeV.objValue;
    }

    @Override // com.repackage.n57
    public qe<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cq4.f();
            return cq4.g("tb.im_group_setting");
        }
        return (qe) invokeV.objValue;
    }

    @Override // com.repackage.n57
    public void h(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                qe<String> b2 = b();
                String str = uid + "@" + gid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
                synchronized (this.a) {
                    this.a.put(str, groupSettingItemData);
                }
                b2.g(str, jsonStrWithObject);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // com.repackage.n57
    public void i(ChatSetting chatSetting, tb5<Void> tb5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, chatSetting, tb5Var) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                String str = uid + "@" + gid;
                synchronized (this.a) {
                    this.a.put(str, groupSettingItemData);
                }
                pc5.c(new b(this, groupSettingItemData, str), tb5Var);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    public void j(String str, String str2, tb5<Void> tb5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, tb5Var) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str + "@" + str2;
        synchronized (this.a) {
            this.a.remove(str3);
        }
        pc5.c(new c(this, str3), tb5Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n57
    /* renamed from: l */
    public GroupSettingItemData a(String str, String str2) {
        InterceptResult invokeLL;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + "@" + str2;
            synchronized (this.a) {
                ChatSetting chatSetting = this.a.get(str3);
                groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
            }
            if (groupSettingItemData == null) {
                GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
                groupSettingItemData2.setUid(str);
                groupSettingItemData2.setGid(str2);
                groupSettingItemData2.setAcceptNotify(true);
                groupSettingItemData2.setInGroup(true);
                return groupSettingItemData2;
            }
            return groupSettingItemData;
        }
        return (GroupSettingItemData) invokeLL.objValue;
    }

    public void m(String str, String str2, long j, tb5<Boolean> tb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j), tb5Var}) == null) {
            pc5.c(new a(this, str, str2, j), tb5Var);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.e(GroupSettingItemData.class);
        }
    }

    public void o(String str, String str2, boolean z, tb5<Void> tb5Var) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Boolean.valueOf(z), tb5Var}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAlreadyApply(z);
        a2.setLastApplyTimeStamp(System.currentTimeMillis());
        i(a2, tb5Var);
    }

    public void p(String str, String str2, boolean z, tb5<Void> tb5Var) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Boolean.valueOf(z), tb5Var}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setInGroup(z);
        i(a2, tb5Var);
    }
}
