package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.VoiceSendModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n45;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l77 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l77 i;
    public static volatile Long j;
    public static volatile long k;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<ChatMessage> a;
    public final HashMap<String, n45<ChatMessage>> b;
    public final Map<String, Map<String, Object>> c;
    public n45.d d;
    public o77 e;
    public VoiceSendModel f;
    public WeakReference<n45.b<ChatMessage>> g;
    public VoiceSendModel.b h;

    /* loaded from: classes6.dex */
    public class a implements n45.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l77 a;

        /* renamed from: com.repackage.l77$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0672a extends de5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupChatMessage a;

            public C0672a(a aVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.de5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(u57.h().o(this.a.getGroupId(), String.valueOf(this.a.getRecordId()), String.valueOf(this.a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements jd5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupChatMessage a;

            public b(a aVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.jd5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    l77.n(this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c extends de5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatMessage a;

            public c(a aVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.de5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(f67.v().t(this.a.getUserId(), this.a.getToUserId(), String.valueOf(this.a.getRecordId()), String.valueOf(this.a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class d implements jd5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatMessage a;

            public d(a aVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.jd5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    l77.n(this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class e extends de5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfficialChatMessage a;

            public e(a aVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.de5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d67.v().t(this.a.getUserId(), this.a.getToUserId(), String.valueOf(this.a.getRecordId()), String.valueOf(this.a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class f implements jd5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfficialChatMessage a;

            public f(a aVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.jd5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    l77.n(this.a);
                }
            }
        }

        public a(l77 l77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l77Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
            com.repackage.mt4.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r14.error_code, r14.error_msg, new java.lang.Object[0]);
         */
        @Override // com.repackage.n45.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            n45 n45Var;
            Map map;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                synchronized (this) {
                    synchronized (l77.class) {
                        n45Var = (n45) this.a.b.remove(str);
                        map = (Map) this.a.c.remove(str);
                    }
                    if (n45Var == null) {
                        return;
                    }
                    ChatMessage chatMessage = (ChatMessage) n45Var.f();
                    if (chatMessage == null) {
                        return;
                    }
                    int i2 = 0;
                    if (imageUploadResult != null && imageUploadResult.error_code == 0 && imageUploadResult.picInfo != null) {
                        mt4.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                        String str2 = null;
                        String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                        if (imageUploadResult.picInfo.smallPic != null) {
                            str2 = imageUploadResult.picInfo.smallPic.picUrl;
                            i2 = imageUploadResult.picInfo.smallPic.width;
                            i = imageUploadResult.picInfo.smallPic.height;
                            this.a.t(str, str2);
                        } else {
                            i = 0;
                        }
                        chatMessage.setContent(l77.g(str3, str2, i2, i, map));
                        l77.k().u(chatMessage);
                        if (this.a.e != null) {
                            this.a.e.a(1);
                        }
                    }
                    mt4.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        he5.c(new C0672a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        he5.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        he5.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonGroupChatMessage a;
        public final /* synthetic */ LinkedList b;

        public b(l77 l77Var, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, commonGroupChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonGroupChatMessage;
            this.b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(u57.h().l(this.a.getGroupId(), this.b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonGroupChatMessage a;
        public final /* synthetic */ ChatMessage b;

        public c(l77 l77Var, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, commonGroupChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonGroupChatMessage;
            this.b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.a.getGroupId(), this.b.getCustomGroupType(), this.b, 3)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatMessage a;
        public final /* synthetic */ LinkedList b;

        public d(l77 l77Var, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, personalChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatMessage;
            this.b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(f67.v().n(a97.o(this.a), this.b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatMessage a;
        public final /* synthetic */ ChatMessage b;

        public e(l77 l77Var, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, personalChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatMessage;
            this.b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.a.getToUserId()), 2, this.b, 3)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialChatMessage a;
        public final /* synthetic */ LinkedList b;

        public f(l77 l77Var, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, officialChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialChatMessage;
            this.b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d67.v().n(a97.o(this.a), this.b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialChatMessage a;
        public final /* synthetic */ ChatMessage b;

        public g(l77 l77Var, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, officialChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialChatMessage;
            this.b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.a.getToUserId()), 4, this.b, 3)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements VoiceSendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l77 a;

        /* loaded from: classes6.dex */
        public class a extends de5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupChatMessage a;

            public a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.de5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(u57.h().o(this.a.getGroupId(), String.valueOf(this.a.getRecordId()), String.valueOf(this.a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements jd5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupChatMessage a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.jd5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    l77.n(this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c extends de5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatMessage a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.de5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(f67.v().u(this.a.getUserId(), this.a.getToUserId(), String.valueOf(this.a.getRecordId()), String.valueOf(this.a.getMsgId()), 2, this.a.getErrorString())) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class d implements jd5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatMessage a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.jd5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    l77.n(this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class e extends de5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfficialChatMessage a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.de5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d67.v().t(this.a.getUserId(), this.a.getToUserId(), String.valueOf(this.a.getRecordId()), String.valueOf(this.a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class f implements jd5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfficialChatMessage a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.jd5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    l77.n(this.a);
                }
            }
        }

        public h(l77 l77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l77Var;
        }

        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, chatMessage) == null) {
                try {
                    l77.k().r(chatMessage);
                    if (chatMessage != null) {
                        if (str != null && str.length() > 0) {
                            VoiceMsgData p = a97.p(chatMessage);
                            if (p != null) {
                                p.setVoice_md5(str);
                                String jsonStrWithObject = OrmObject.jsonStrWithObject(p);
                                chatMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                            }
                            mt4.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                            l77.k().u(chatMessage);
                            if (this.a.e != null) {
                                this.a.e.a(2);
                                return;
                            }
                            return;
                        }
                        mt4.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                        if (chatMessage instanceof CommonGroupChatMessage) {
                            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                            he5.c(new a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                        } else if (chatMessage instanceof PersonalChatMessage) {
                            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                            he5.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                        } else if (chatMessage instanceof OfficialChatMessage) {
                            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                            he5.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ l77 c;

        public i(l77 l77Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l77Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? BitmapFactory.decodeFile(this.a) : (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                this.c.s(this.b, new ym(bitmap, false));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends de5<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public j(l77 l77Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? u57.h().f(this.a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements jd5<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n77 a;

        public k(l77 l77Var, n77 n77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, n77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n77Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String h = a97.h(str3, true);
                        if (h != null) {
                            linkedHashMap2.put(str2, h);
                        }
                        String h2 = a97.h(str3, false);
                        if (!TextUtils.isEmpty(h2) && !TextUtils.isEmpty(h)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = h2;
                            imageUrlData.urlType = 10;
                            hashMap.put(h, imageUrlData);
                        }
                    }
                }
                this.a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends de5<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public l(l77 l77Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f67.v().g(this.a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements jd5<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n77 a;

        public m(l77 l77Var, n77 n77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, n77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n77Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String h = a97.h(str3, true);
                        if (h != null) {
                            linkedHashMap2.put(str2, h);
                        }
                        String h2 = a97.h(str3, false);
                        if (!TextUtils.isEmpty(h2) && !TextUtils.isEmpty(h)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = h2;
                            imageUrlData.urlType = 10;
                            hashMap.put(h, imageUrlData);
                        }
                    }
                }
                this.a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends de5<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public n(l77 l77Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d67.v().g(this.a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements jd5<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n77 a;

        public o(l77 l77Var, n77 n77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, n77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n77Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String h = a97.h(str3, true);
                        if (h != null) {
                            linkedHashMap2.put(str2, h);
                        }
                        String h2 = a97.h(str3, false);
                        if (!TextUtils.isEmpty(h2) && !TextUtils.isEmpty(h)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = h2;
                            imageUrlData.urlType = 10;
                            hashMap.put(h, imageUrlData);
                        }
                    }
                }
                this.a.a(linkedHashMap2, hashMap);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755576091, "Lcom/repackage/l77;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755576091, "Lcom/repackage/l77;");
                return;
            }
        }
        j = 0L;
        k = 0L;
    }

    public l77() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedList<>();
        this.b = new HashMap<>();
        this.c = new HashMap();
        this.h = new h(this);
        l();
    }

    public static String g(String str, String str2, int i2, int i3, @Nullable Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            PicMessageData picMessageData = new PicMessageData();
            picMessageData.src = str2;
            picMessageData.big_src = str;
            picMessageData.type = "3";
            if (i2 > 0) {
                picMessageData.bsize = i2 + "," + i3;
            }
            HashMap hashMap = new HashMap(DataExt.toMap(picMessageData));
            if (map != null) {
                hashMap.putAll(map);
            }
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(new JSONObject(DataExt.toJson(hashMap)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONArray.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static l77 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (l77.class) {
                    if (i == null) {
                        i = new l77();
                    }
                }
            }
            return i;
        }
        return (l77) invokeV.objValue;
    }

    public static void n(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, chatMessage) == null) {
            String groupId = chatMessage.getGroupId();
            if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                groupId = String.valueOf(chatMessage.getToUserId());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
        }
    }

    public static void y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, null, j2) == null) {
            k = j2;
        }
    }

    public static void z(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j2) == null) {
            j = Long.valueOf(j2);
        }
    }

    public void A(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, chatMessage, str) == null) {
            n45<ChatMessage> n45Var = this.b.get(str);
            if (n45Var == null) {
                n45Var = new n45<>(str, "IM");
                n45Var.j();
                n45Var.i(chatMessage);
                WeakReference<n45.b<ChatMessage>> weakReference = this.g;
                if (weakReference != null && weakReference.get() != null) {
                    n45Var.m(this.g.get());
                }
                n45Var.l(this.d);
                if (chatMessage instanceof CommonGroupChatMessage) {
                    n45Var.h(((CommonGroupChatMessage) chatMessage).getGroupId());
                } else if (chatMessage instanceof PersonalChatMessage) {
                    n45Var.h(String.valueOf(j));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    n45Var.h(String.valueOf(k));
                }
                synchronized (l77.class) {
                    this.b.put(str, n45Var);
                }
            }
            chatMessage.setLogTime(System.currentTimeMillis());
            n(chatMessage);
            n45Var.g(false);
        }
    }

    public void B(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceMsgData, chatMessage) == null) {
            m(chatMessage);
            if (chatMessage != null) {
                chatMessage.getClientLogID();
                chatMessage.getCmd();
            }
            this.f.C(voiceMsgData.getVoice_md5(), chatMessage);
        }
    }

    public boolean h(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage)) == null) {
            HashMap<String, n45<ChatMessage>> hashMap = this.b;
            if (hashMap != null && chatMessage != null) {
                for (Map.Entry<String, n45<ChatMessage>> entry : hashMap.entrySet()) {
                    n45<ChatMessage> value = entry.getValue();
                    if (value != null && value.f() != null) {
                        ChatMessage f2 = value.f();
                        if (chatMessage.getRecordId() != f2.getRecordId()) {
                            continue;
                        } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                            if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                                WeakReference<n45.b<ChatMessage>> weakReference = this.g;
                                if (weakReference != null && weakReference.get() != null) {
                                    value.m(this.g.get());
                                }
                                return true;
                            }
                        } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                            WeakReference<n45.b<ChatMessage>> weakReference2 = this.g;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                value.m(this.g.get());
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean i(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, chatMessage)) == null) ? j(chatMessage, this.a) != -1 : invokeL.booleanValue;
    }

    public final int j(ChatMessage chatMessage, LinkedList<ChatMessage> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, chatMessage, linkedList)) == null) {
            if (chatMessage == null || linkedList == null || linkedList.size() == 0) {
                return -1;
            }
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ChatMessage chatMessage2 = linkedList.get(i2);
                if (chatMessage2 != null && chatMessage.getRecordId() == chatMessage2.getRecordId()) {
                    if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && chatMessage2.getGroupId() != null && chatMessage.getGroupId().equals(chatMessage2.getGroupId())) {
                            return i2;
                        }
                    } else if (chatMessage.getToUserId() == chatMessage2.getToUserId()) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            VoiceSendModel voiceSendModel = new VoiceSendModel(null);
            this.f = voiceSendModel;
            voiceSendModel.B(this.h);
            this.d = new a(this);
        }
    }

    public final void m(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        this.a.add(chatMessage);
    }

    public void o(String str, n77 n77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, n77Var) == null) {
            he5.c(new j(this, str), new k(this, n77Var));
        }
    }

    public void p(String str, n77 n77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, n77Var) == null) {
            he5.c(new n(this, str), new o(this, n77Var));
        }
    }

    public void q(String str, n77 n77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, n77Var) == null) {
            he5.c(new l(this, str), new m(this, n77Var));
        }
    }

    public final void r(ChatMessage chatMessage) {
        int j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, chatMessage) == null) || (j2 = j(chatMessage, this.a)) < 0) {
            return;
        }
        this.a.remove(j2);
    }

    public final void s(String str, ym ymVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, ymVar) == null) {
            l45.k().d(str, ymVar);
            yb ybVar = new yb("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
            ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ybVar.setSubFolder(true);
            ybVar.setData(ymVar.n());
            ybVar.setGif(false);
            ub.f().a(ybVar);
        }
    }

    public final void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            ym m2 = l45.k().m(str);
            String str3 = str2 + 10;
            if (m2 != null && m2.w()) {
                s(str3, m2);
            } else {
                new i(this, str, str3).execute(new Void[0]);
            }
        }
    }

    public void u(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, chatMessage) == null) {
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                he5.c(new b(this, commonGroupChatMessage, linkedList), new c(this, commonGroupChatMessage, chatMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                he5.c(new d(this, personalChatMessage, linkedList2), new e(this, personalChatMessage, chatMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                he5.c(new f(this, officialChatMessage, linkedList3), new g(this, officialChatMessage, chatMessage));
            }
        }
    }

    public void v(n45.b<ChatMessage> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.g = new WeakReference<>(bVar);
        }
    }

    public void w(o77 o77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, o77Var) == null) {
            this.e = o77Var;
        }
    }

    public void x(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, map) == null) {
            this.c.put(str, map);
        }
    }
}
