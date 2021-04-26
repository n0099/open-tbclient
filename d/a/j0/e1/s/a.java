package d.a.j0.e1.s;

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
import d.a.i0.b0.a;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
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
    public static volatile a f53798h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Long f53799i = 0L;
    public static volatile long j = 0;

    /* renamed from: c  reason: collision with root package name */
    public a.d f53802c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.e1.s.d f53803d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f53804e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f53805f;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f53800a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d.a.i0.b0.a<ChatMessage>> f53801b = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f53806g = new h();

    /* renamed from: d.a.j0.e1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1235a implements a.d {

        /* renamed from: d.a.j0.e1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1236a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f53808a;

            public C1236a(C1235a c1235a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f53808a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.j0.e1.h.c.h().o(this.f53808a.getGroupId(), String.valueOf(this.f53808a.getRecordId()), String.valueOf(this.f53808a.getMsgId()), 2));
            }
        }

        /* renamed from: d.a.j0.e1.s.a$a$b */
        /* loaded from: classes4.dex */
        public class b implements d.a.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f53809a;

            public b(C1235a c1235a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f53809a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f53809a);
            }
        }

        /* renamed from: d.a.j0.e1.s.a$a$c */
        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f53810a;

            public c(C1235a c1235a, PersonalChatMessage personalChatMessage) {
                this.f53810a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.j0.e1.h.m.t().s(this.f53810a.getUserId(), this.f53810a.getToUserId(), String.valueOf(this.f53810a.getRecordId()), String.valueOf(this.f53810a.getMsgId()), 2));
            }
        }

        /* renamed from: d.a.j0.e1.s.a$a$d */
        /* loaded from: classes4.dex */
        public class d implements d.a.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f53811a;

            public d(C1235a c1235a, PersonalChatMessage personalChatMessage) {
                this.f53811a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f53811a);
            }
        }

        /* renamed from: d.a.j0.e1.s.a$a$e */
        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f53812a;

            public e(C1235a c1235a, OfficialChatMessage officialChatMessage) {
                this.f53812a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.j0.e1.h.l.t().s(this.f53812a.getUserId(), this.f53812a.getToUserId(), String.valueOf(this.f53812a.getRecordId()), String.valueOf(this.f53812a.getMsgId()), 2));
            }
        }

        /* renamed from: d.a.j0.e1.s.a$a$f */
        /* loaded from: classes4.dex */
        public class f implements d.a.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f53813a;

            public f(C1235a c1235a, OfficialChatMessage officialChatMessage) {
                this.f53813a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f53813a);
            }
        }

        public C1235a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
            d.a.i0.r.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // d.a.i0.b0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            d.a.i0.b0.a aVar;
            int i2;
            synchronized (a.class) {
                aVar = (d.a.i0.b0.a) a.this.f53801b.remove(str);
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
                d.a.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
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
                if (a.this.f53803d != null) {
                    a.this.f53803d.a(1);
                }
            }
            d.a.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                h0.c(new C1236a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
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
        public final /* synthetic */ CommonGroupChatMessage f53814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f53815b;

        public b(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f53814a = commonGroupChatMessage;
            this.f53815b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.j0.e1.h.c.h().l(this.f53814a.getGroupId(), this.f53815b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.i0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f53816a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f53817b;

        public c(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            this.f53816a = commonGroupChatMessage;
            this.f53817b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f53816a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f53816a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f53816a.getGroupId(), this.f53817b.getCustomGroupType(), this.f53817b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f53818a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f53819b;

        public d(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            this.f53818a = personalChatMessage;
            this.f53819b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.j0.e1.h.m.t().m(d.a.j0.e1.w.c.m(this.f53818a), this.f53819b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.i0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f53820a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f53821b;

        public e(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            this.f53820a = personalChatMessage;
            this.f53821b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f53820a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f53820a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f53820a.getToUserId()), 2, this.f53821b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class f extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f53822a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f53823b;

        public f(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            this.f53822a = officialChatMessage;
            this.f53823b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.j0.e1.h.l.t().m(d.a.j0.e1.w.c.m(this.f53822a), this.f53823b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.i0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f53824a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f53825b;

        public g(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            this.f53824a = officialChatMessage;
            this.f53825b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f53824a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f53824a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f53824a.getToUserId()), 4, this.f53825b, 3)));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements VoiceSendModel.b {

        /* renamed from: d.a.j0.e1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1237a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f53827a;

            public C1237a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f53827a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.j0.e1.h.c.h().o(this.f53827a.getGroupId(), String.valueOf(this.f53827a.getRecordId()), String.valueOf(this.f53827a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f53828a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f53828a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f53828a);
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f53829a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                this.f53829a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.j0.e1.h.m.t().s(this.f53829a.getUserId(), this.f53829a.getToUserId(), String.valueOf(this.f53829a.getRecordId()), String.valueOf(this.f53829a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.a.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f53830a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                this.f53830a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f53830a);
            }
        }

        /* loaded from: classes4.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f53831a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                this.f53831a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.j0.e1.h.l.t().s(this.f53831a.getUserId(), this.f53831a.getToUserId(), String.valueOf(this.f53831a.getRecordId()), String.valueOf(this.f53831a.getMsgId()), 2));
            }
        }

        /* loaded from: classes4.dex */
        public class f implements d.a.i0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f53832a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                this.f53832a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f53832a);
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
                        VoiceMsgData n = d.a.j0.e1.w.c.n(chatMessage);
                        if (n != null) {
                            n.setVoice_md5(str);
                            String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                            chatMessage.setContent("[" + jsonStrWithObject + "]");
                        }
                        d.a.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                        a.j().t(chatMessage);
                        if (a.this.f53803d != null) {
                            a.this.f53803d.a(2);
                            return;
                        }
                        return;
                    }
                    d.a.i0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        h0.c(new C1237a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
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
        public final /* synthetic */ String f53833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53834b;

        public i(String str, String str2) {
            this.f53833a = str;
            this.f53834b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            return BitmapFactory.decodeFile(this.f53833a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            a.this.r(this.f53834b, new d.a.c.j.d.a(bitmap, false));
        }
    }

    /* loaded from: classes4.dex */
    public class j extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53836a;

        public j(a aVar, String str) {
            this.f53836a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.a.j0.e1.h.c.h().f(this.f53836a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements d.a.i0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.e1.s.c f53837a;

        public k(a aVar, d.a.j0.e1.s.c cVar) {
            this.f53837a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
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
                    String f2 = d.a.j0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.a.j0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f53837a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53838a;

        public l(a aVar, String str) {
            this.f53838a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.a.j0.e1.h.m.t().f(this.f53838a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d.a.i0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.e1.s.c f53839a;

        public m(a aVar, d.a.j0.e1.s.c cVar) {
            this.f53839a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
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
                    String f2 = d.a.j0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.a.j0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f53839a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class n extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53840a;

        public n(a aVar, String str) {
            this.f53840a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.a.j0.e1.h.l.t().f(this.f53840a, 2, null, 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.a.i0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.e1.s.c f53841a;

        public o(a aVar, d.a.j0.e1.s.c cVar) {
            this.f53841a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
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
                    String f2 = d.a.j0.e1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.a.j0.e1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f53841a.a(linkedHashMap2, hashMap);
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
        if (f53798h == null) {
            synchronized (a.class) {
                if (f53798h == null) {
                    f53798h = new a();
                }
            }
        }
        return f53798h;
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
        f53799i = Long.valueOf(j2);
    }

    public boolean g(ChatMessage chatMessage) {
        HashMap<String, d.a.i0.b0.a<ChatMessage>> hashMap = this.f53801b;
        if (hashMap != null && chatMessage != null) {
            for (Map.Entry<String, d.a.i0.b0.a<ChatMessage>> entry : hashMap.entrySet()) {
                d.a.i0.b0.a<ChatMessage> value = entry.getValue();
                if (value != null && value.f() != null) {
                    ChatMessage f2 = value.f();
                    if (chatMessage.getRecordId() != f2.getRecordId()) {
                        continue;
                    } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                            WeakReference<a.b<ChatMessage>> weakReference = this.f53805f;
                            if (weakReference != null && weakReference.get() != null) {
                                value.m(this.f53805f.get());
                            }
                            return true;
                        }
                    } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                        WeakReference<a.b<ChatMessage>> weakReference2 = this.f53805f;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            value.m(this.f53805f.get());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean h(ChatMessage chatMessage) {
        return i(chatMessage, this.f53800a) != -1;
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
        this.f53804e = voiceSendModel;
        voiceSendModel.t(this.f53806g);
        this.f53802c = new C1235a();
    }

    public final void l(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return;
        }
        this.f53800a.add(chatMessage);
    }

    public void n(String str, d.a.j0.e1.s.c cVar) {
        h0.c(new j(this, str), new k(this, cVar));
    }

    public void o(String str, d.a.j0.e1.s.c cVar) {
        h0.c(new n(this, str), new o(this, cVar));
    }

    public void p(String str, d.a.j0.e1.s.c cVar) {
        h0.c(new l(this, str), new m(this, cVar));
    }

    public final void q(ChatMessage chatMessage) {
        int i2 = i(chatMessage, this.f53800a);
        if (i2 >= 0) {
            this.f53800a.remove(i2);
        }
    }

    public final void r(String str, d.a.c.j.d.a aVar) {
        d.a.i0.a0.c.k().d(str, aVar);
        d.a.c.e.a.f.c cVar = new d.a.c.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(aVar.n());
        cVar.setGif(false);
        d.a.c.e.a.d.g().a(cVar);
    }

    public final void s(String str, String str2) {
        d.a.c.j.d.a m2 = d.a.i0.a0.c.k().m(str);
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
        this.f53805f = new WeakReference<>(bVar);
    }

    public void v(d.a.j0.e1.s.d dVar) {
        this.f53803d = dVar;
    }

    public void y(ChatMessage chatMessage, String str) {
        d.a.i0.b0.a<ChatMessage> aVar = this.f53801b.get(str);
        if (aVar == null) {
            aVar = new d.a.i0.b0.a<>(str, "IM");
            aVar.j();
            aVar.i(chatMessage);
            WeakReference<a.b<ChatMessage>> weakReference = this.f53805f;
            if (weakReference != null && weakReference.get() != null) {
                aVar.m(this.f53805f.get());
            }
            aVar.l(this.f53802c);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar.h(String.valueOf(f53799i));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar.h(String.valueOf(j));
            }
            synchronized (a.class) {
                this.f53801b.put(str, aVar);
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
        this.f53804e.u(voiceMsgData.getVoice_md5(), chatMessage);
    }
}
