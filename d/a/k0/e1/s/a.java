package d.a.k0.e1.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.VoiceSendModel;
import d.a.j0.b0.a;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f54505h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Long f54506i = 0L;
    public static volatile long j = 0;

    /* renamed from: c  reason: collision with root package name */
    public a.d f54509c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.e1.s.d f54510d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f54511e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f54512f;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f54507a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d.a.j0.b0.a<ChatMessage>> f54508b = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f54513g = new h();

    /* renamed from: d.a.k0.e1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1307a implements a.d {

        /* renamed from: d.a.k0.e1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1308a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f54515a;

            public C1308a(C1307a c1307a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f54515a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.j0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.k0.e1.h.c.h().o(this.f54515a.getGroupId(), String.valueOf(this.f54515a.getRecordId()), String.valueOf(this.f54515a.getMsgId()), 2));
            }
        }

        /* renamed from: d.a.k0.e1.s.a$a$b */
        /* loaded from: classes4.dex */
        public class b implements d.a.j0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f54516a;

            public b(C1307a c1307a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f54516a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54516a);
            }
        }

        /* renamed from: d.a.k0.e1.s.a$a$c */
        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f54517a;

            public c(C1307a c1307a, PersonalChatMessage personalChatMessage) {
                this.f54517a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.j0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.k0.e1.h.m.t().s(this.f54517a.getUserId(), this.f54517a.getToUserId(), String.valueOf(this.f54517a.getRecordId()), String.valueOf(this.f54517a.getMsgId()), 2));
            }
        }

        /* renamed from: d.a.k0.e1.s.a$a$d */
        /* loaded from: classes4.dex */
        public class d implements d.a.j0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f54518a;

            public d(C1307a c1307a, PersonalChatMessage personalChatMessage) {
                this.f54518a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54518a);
            }
        }

        /* renamed from: d.a.k0.e1.s.a$a$e */
        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54519a;

            public e(C1307a c1307a, OfficialChatMessage officialChatMessage) {
                this.f54519a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.j0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.k0.e1.h.l.t().s(this.f54519a.getUserId(), this.f54519a.getToUserId(), String.valueOf(this.f54519a.getRecordId()), String.valueOf(this.f54519a.getMsgId()), 2));
            }
        }

        /* renamed from: d.a.k0.e1.s.a$a$f */
        /* loaded from: classes4.dex */
        public class f implements d.a.j0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54520a;

            public f(C1307a c1307a, OfficialChatMessage officialChatMessage) {
                this.f54520a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54520a);
            }
        }

        public C1307a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
            d.a.j0.r.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // d.a.j0.b0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            d.a.j0.b0.a aVar;
            int i2;
            synchronized (a.class) {
                aVar = (d.a.j0.b0.a) a.this.f54508b.remove(str);
            }
            if (aVar == null) {
                return;
            }
            ChatMessage chatMessage = (ChatMessage) aVar.f();
            if (chatMessage == null) {
                return;
            }
            int i3 = 0;
            if (imageUploadResult != null && imageUploadResult.error_code == 0 && imageUploadResult.picInfo != null) {
                d.a.j0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                String str2 = null;
                String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                if (imageUploadResult.picInfo.smallPic != null) {
                    str2 = imageUploadResult.picInfo.smallPic.picUrl;
                    i3 = imageUploadResult.picInfo.smallPic.width;
                    i2 = imageUploadResult.picInfo.smallPic.height;
                    a.this.s(str, str2);
                } else {
                    i2 = 0;
                }
                chatMessage.setContent(a.f(str3, str2, i3, i2));
                a.j().t(chatMessage);
                if (a.this.f54510d != null) {
                    a.this.f54510d.a(1);
                }
            }
            d.a.j0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                h0.c(new C1308a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                h0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                h0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f54521a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f54522b;

        public b(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f54521a = commonGroupChatMessage;
            this.f54522b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.j0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.k0.e1.h.c.h().l(this.f54521a.getGroupId(), this.f54522b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.j0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f54523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f54524b;

        public c(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            this.f54523a = commonGroupChatMessage;
            this.f54524b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f54523a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f54523a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f54523a.getGroupId(), this.f54524b.getCustomGroupType(), this.f54524b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f54525a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f54526b;

        public d(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            this.f54525a = personalChatMessage;
            this.f54526b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.j0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.k0.e1.h.m.t().m(d.a.k0.e1.w.c.m(this.f54525a), this.f54526b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.j0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f54527a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f54528b;

        public e(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            this.f54527a = personalChatMessage;
            this.f54528b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f54527a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f54527a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f54527a.getToUserId()), 2, this.f54528b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class f extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f54529a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f54530b;

        public f(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            this.f54529a = officialChatMessage;
            this.f54530b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.j0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.k0.e1.h.l.t().m(d.a.k0.e1.w.c.m(this.f54529a), this.f54530b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.j0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f54531a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f54532b;

        public g(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            this.f54531a = officialChatMessage;
            this.f54532b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f54531a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f54531a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f54531a.getToUserId()), 4, this.f54532b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements VoiceSendModel.b {

        /* renamed from: d.a.k0.e1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1309a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f54534a;

            public C1309a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f54534a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.j0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.k0.e1.h.c.h().o(this.f54534a.getGroupId(), String.valueOf(this.f54534a.getRecordId()), String.valueOf(this.f54534a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.j0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f54535a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f54535a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54535a);
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f54536a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                this.f54536a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.j0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.k0.e1.h.m.t().s(this.f54536a.getUserId(), this.f54536a.getToUserId(), String.valueOf(this.f54536a.getRecordId()), String.valueOf(this.f54536a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.a.j0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f54537a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                this.f54537a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54537a);
            }
        }

        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54538a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                this.f54538a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.j0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.k0.e1.h.l.t().s(this.f54538a.getUserId(), this.f54538a.getToUserId(), String.valueOf(this.f54538a.getRecordId()), String.valueOf(this.f54538a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class f implements d.a.j0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54539a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                this.f54539a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54539a);
            }
        }

        public h() {
        }

        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            try {
                a.j().q(chatMessage);
                if (chatMessage != null) {
                    if (str != null && str.length() > 0) {
                        VoiceMsgData n = d.a.k0.e1.w.c.n(chatMessage);
                        if (n != null) {
                            n.setVoice_md5(str);
                            String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                            chatMessage.setContent("[" + jsonStrWithObject + "]");
                        }
                        d.a.j0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                        a.j().t(chatMessage);
                        if (a.this.f54510d != null) {
                            a.this.f54510d.a(2);
                            return;
                        }
                        return;
                    }
                    d.a.j0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        h0.c(new C1309a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        h0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        h0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54541b;

        public i(String str, String str2) {
            this.f54540a = str;
            this.f54541b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            return BitmapFactory.decodeFile(this.f54540a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            a.this.r(this.f54541b, new d.a.c.j.d.a(bitmap, false));
        }
    }

    /* loaded from: classes4.dex */
    public class j extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54543a;

        public j(a aVar, String str) {
            this.f54543a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.a.k0.e1.h.c.h().f(this.f54543a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements d.a.j0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.s.c f54544a;

        public k(a aVar, d.a.k0.e1.s.c cVar) {
            this.f54544a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
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
                    String f2 = d.a.k0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.a.k0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f54544a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54545a;

        public l(a aVar, String str) {
            this.f54545a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.a.k0.e1.h.m.t().f(this.f54545a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d.a.j0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.s.c f54546a;

        public m(a aVar, d.a.k0.e1.s.c cVar) {
            this.f54546a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
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
                    String f2 = d.a.k0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.a.k0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f54546a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class n extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54547a;

        public n(a aVar, String str) {
            this.f54547a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.a.k0.e1.h.l.t().f(this.f54547a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.a.j0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.s.c f54548a;

        public o(a aVar, d.a.k0.e1.s.c cVar) {
            this.f54548a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
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
                    String f2 = d.a.k0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.a.k0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f54548a.a(linkedHashMap2, hashMap);
        }
    }

    public a() {
        k();
    }

    public static String f(String str, String str2, int i2, int i3) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = "3";
        if (i2 > 0) {
            picMessageData.bsize = i2 + "," + i3;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(OrmObject.jsonWithObject(picMessageData));
        return jSONArray.toString();
    }

    public static a j() {
        if (f54505h == null) {
            synchronized (a.class) {
                if (f54505h == null) {
                    f54505h = new a();
                }
            }
        }
        return f54505h;
    }

    public static void m(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    public static void w(long j2) {
        j = j2;
    }

    public static void x(long j2) {
        f54506i = Long.valueOf(j2);
    }

    public boolean g(ChatMessage chatMessage) {
        HashMap<String, d.a.j0.b0.a<ChatMessage>> hashMap = this.f54508b;
        if (hashMap != null && chatMessage != null) {
            for (Map.Entry<String, d.a.j0.b0.a<ChatMessage>> entry : hashMap.entrySet()) {
                d.a.j0.b0.a<ChatMessage> value = entry.getValue();
                if (value != null && value.f() != null) {
                    ChatMessage f2 = value.f();
                    if (chatMessage.getRecordId() != f2.getRecordId()) {
                        continue;
                    } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                            WeakReference<a.b<ChatMessage>> weakReference = this.f54512f;
                            if (weakReference != null && weakReference.get() != null) {
                                value.m(this.f54512f.get());
                            }
                            return true;
                        }
                    } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                        WeakReference<a.b<ChatMessage>> weakReference2 = this.f54512f;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            value.m(this.f54512f.get());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean h(ChatMessage chatMessage) {
        return i(chatMessage, this.f54507a) != -1;
    }

    public final int i(ChatMessage chatMessage, LinkedList<ChatMessage> linkedList) {
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

    public final void k() {
        VoiceSendModel voiceSendModel = new VoiceSendModel(null);
        this.f54511e = voiceSendModel;
        voiceSendModel.t(this.f54513g);
        this.f54509c = new C1307a();
    }

    public final void l(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return;
        }
        this.f54507a.add(chatMessage);
    }

    public void n(String str, d.a.k0.e1.s.c cVar) {
        h0.c(new j(this, str), new k(this, cVar));
    }

    public void o(String str, d.a.k0.e1.s.c cVar) {
        h0.c(new n(this, str), new o(this, cVar));
    }

    public void p(String str, d.a.k0.e1.s.c cVar) {
        h0.c(new l(this, str), new m(this, cVar));
    }

    public final void q(ChatMessage chatMessage) {
        int i2 = i(chatMessage, this.f54507a);
        if (i2 >= 0) {
            this.f54507a.remove(i2);
        }
    }

    public final void r(String str, d.a.c.j.d.a aVar) {
        d.a.j0.a0.c.k().d(str, aVar);
        d.a.c.e.a.f.c cVar = new d.a.c.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(aVar.n());
        cVar.setGif(false);
        d.a.c.e.a.d.g().a(cVar);
    }

    public final void s(String str, String str2) {
        d.a.c.j.d.a m2 = d.a.j0.a0.c.k().m(str);
        String str3 = str2 + 10;
        if (m2 != null && m2.w()) {
            r(str3, m2);
        } else {
            new i(str, str3).execute(new Void[0]);
        }
    }

    public void t(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            h0.c(new b(this, commonGroupChatMessage, linkedList), new c(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            h0.c(new d(this, personalChatMessage, linkedList2), new e(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            h0.c(new f(this, officialChatMessage, linkedList3), new g(this, officialChatMessage, chatMessage));
        }
    }

    public void u(a.b<ChatMessage> bVar) {
        this.f54512f = new WeakReference<>(bVar);
    }

    public void v(d.a.k0.e1.s.d dVar) {
        this.f54510d = dVar;
    }

    public void y(ChatMessage chatMessage, String str) {
        d.a.j0.b0.a<ChatMessage> aVar = this.f54508b.get(str);
        if (aVar == null) {
            aVar = new d.a.j0.b0.a<>(str, "IM");
            aVar.j();
            aVar.i(chatMessage);
            WeakReference<a.b<ChatMessage>> weakReference = this.f54512f;
            if (weakReference != null && weakReference.get() != null) {
                aVar.m(this.f54512f.get());
            }
            aVar.l(this.f54509c);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar.h(String.valueOf(f54506i));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar.h(String.valueOf(j));
            }
            synchronized (a.class) {
                this.f54508b.put(str, aVar);
            }
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        m(chatMessage);
        aVar.g(false);
    }

    public void z(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        l(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.f54511e.u(voiceMsgData.getVoice_md5(), chatMessage);
    }
}
