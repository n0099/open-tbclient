package d.a.q0.i1.t;

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
import com.bytedance.sdk.component.net.tnc.TNCManager;
import d.a.d.e.d.l;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.b1.n;
/* loaded from: classes8.dex */
public class b extends d.a.q0.i1.t.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f59279b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59280a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59281b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f59282c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f59283d;

        public a(b bVar, String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59283d = bVar;
            this.f59280a = str;
            this.f59281b = str2;
            this.f59282c = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.p0.b1.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                GroupSettingItemData a2 = this.f59283d.a(this.f59280a, this.f59281b);
                if (a2 != null && a2.isAlreadyApply()) {
                    if (System.currentTimeMillis() - a2.getLastApplyTimeStamp() <= this.f59282c) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: d.a.q0.i1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1484b extends f0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupSettingItemData f59284a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59285b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f59286c;

        public C1484b(b bVar, GroupSettingItemData groupSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, groupSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59286c = bVar;
            this.f59284a = groupSettingItemData;
            this.f59285b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f59286c.b().g(this.f59285b, OrmObject.jsonStrWithObject(this.f59284a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends f0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59287a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f59288b;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59288b = bVar;
            this.f59287a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f59288b.b().remove(this.f59287a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366326864, "Ld/a/q0/i1/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366326864, "Ld/a/q0/i1/t/b;");
                return;
            }
        }
        f59279b = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f59279b : (b) invokeV.objValue;
    }

    @Override // d.a.q0.i1.t.a
    public l<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.p0.s.r.a.f().g("tb.im_group_setting") : (l) invokeV.objValue;
    }

    @Override // d.a.q0.i1.t.a
    public void h(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                l<String> b2 = b();
                String str = uid + TNCManager.TNC_PROBE_HEADER_SECEPTOR + gid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
                synchronized (this.f59275a) {
                    this.f59275a.put(str, groupSettingItemData);
                }
                b2.g(str, jsonStrWithObject);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // d.a.q0.i1.t.a
    public void i(ChatSetting chatSetting, n<Void> nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, chatSetting, nVar) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                String str = uid + TNCManager.TNC_PROBE_HEADER_SECEPTOR + gid;
                synchronized (this.f59275a) {
                    this.f59275a.put(str, groupSettingItemData);
                }
                i0.c(new C1484b(this, groupSettingItemData, str), nVar);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    public void j(String str, String str2, n<Void> nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, nVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str + TNCManager.TNC_PROBE_HEADER_SECEPTOR + str2;
        synchronized (this.f59275a) {
            this.f59275a.remove(str3);
        }
        i0.c(new c(this, str3), nVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.i1.t.a
    /* renamed from: l */
    public GroupSettingItemData a(String str, String str2) {
        InterceptResult invokeLL;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + TNCManager.TNC_PROBE_HEADER_SECEPTOR + str2;
            synchronized (this.f59275a) {
                ChatSetting chatSetting = this.f59275a.get(str3);
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

    public void m(String str, String str2, long j, n<Boolean> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j), nVar}) == null) {
            i0.c(new a(this, str, str2, j), nVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.e(GroupSettingItemData.class);
        }
    }

    public void o(String str, String str2, boolean z, n<Void> nVar) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Boolean.valueOf(z), nVar}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAlreadyApply(z);
        a2.setLastApplyTimeStamp(System.currentTimeMillis());
        i(a2, nVar);
    }

    public void p(String str, String str2, boolean z, n<Void> nVar) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Boolean.valueOf(z), nVar}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setInGroup(z);
        i(a2, nVar);
    }
}
