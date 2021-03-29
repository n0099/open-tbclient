package d.b.i0.d1.s;

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
import d.b.h0.b0.a;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f53988h;
    public static volatile Long i = 0L;
    public static volatile long j = 0;

    /* renamed from: c  reason: collision with root package name */
    public a.d f53991c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.d1.s.d f53992d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f53993e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f53994f;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f53989a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d.b.h0.b0.a<ChatMessage>> f53990b = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f53995g = new h();

    /* renamed from: d.b.i0.d1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1210a implements a.d {

        /* renamed from: d.b.i0.d1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1211a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f53997a;

            public C1211a(C1210a c1210a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f53997a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.d1.h.c.h().o(this.f53997a.getGroupId(), String.valueOf(this.f53997a.getRecordId()), String.valueOf(this.f53997a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.i0.d1.s.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f53998a;

            public b(C1210a c1210a, CommonGroupChatMessage commonGroupChatMessage) {
                this.f53998a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f53998a);
            }
        }

        /* renamed from: d.b.i0.d1.s.a$a$c */
        /* loaded from: classes3.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f53999a;

            public c(C1210a c1210a, PersonalChatMessage personalChatMessage) {
                this.f53999a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.d1.h.m.t().s(this.f53999a.getUserId(), this.f53999a.getToUserId(), String.valueOf(this.f53999a.getRecordId()), String.valueOf(this.f53999a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.i0.d1.s.a$a$d */
        /* loaded from: classes3.dex */
        public class d implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f54000a;

            public d(C1210a c1210a, PersonalChatMessage personalChatMessage) {
                this.f54000a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54000a);
            }
        }

        /* renamed from: d.b.i0.d1.s.a$a$e */
        /* loaded from: classes3.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54001a;

            public e(C1210a c1210a, OfficialChatMessage officialChatMessage) {
                this.f54001a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.d1.h.l.t().s(this.f54001a.getUserId(), this.f54001a.getToUserId(), String.valueOf(this.f54001a.getRecordId()), String.valueOf(this.f54001a.getMsgId()), 2));
            }
        }

        /* renamed from: d.b.i0.d1.s.a$a$f */
        /* loaded from: classes3.dex */
        public class f implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54002a;

            public f(C1210a c1210a, OfficialChatMessage officialChatMessage) {
                this.f54002a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54002a);
            }
        }

        public C1210a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
            d.b.h0.r.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // d.b.h0.b0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            d.b.h0.b0.a aVar;
            int i;
            synchronized (a.class) {
                aVar = (d.b.h0.b0.a) a.this.f53990b.remove(str);
            }
            if (aVar == null) {
                return;
            }
            ChatMessage chatMessage = (ChatMessage) aVar.f();
            if (chatMessage == null) {
                return;
            }
            int i2 = 0;
            if (imageUploadResult != null && imageUploadResult.error_code == 0 && imageUploadResult.picInfo != null) {
                d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                String str2 = null;
                String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                if (imageUploadResult.picInfo.smallPic != null) {
                    str2 = imageUploadResult.picInfo.smallPic.picUrl;
                    i2 = imageUploadResult.picInfo.smallPic.width;
                    i = imageUploadResult.picInfo.smallPic.height;
                    a.this.s(str, str2);
                } else {
                    i = 0;
                }
                chatMessage.setContent(a.f(str3, str2, i2, i));
                a.j().t(chatMessage);
                if (a.this.f53992d != null) {
                    a.this.f53992d.a(1);
                }
            }
            d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                h0.c(new C1211a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                h0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                h0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f54003a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f54004b;

        public b(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f54003a = commonGroupChatMessage;
            this.f54004b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.i0.d1.h.c.h().l(this.f54003a.getGroupId(), this.f54004b, false));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.h0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f54005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f54006b;

        public c(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            this.f54005a = commonGroupChatMessage;
            this.f54006b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f54005a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f54005a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f54005a.getGroupId(), this.f54006b.getCustomGroupType(), this.f54006b, 3)));
        }
    }

    /* loaded from: classes3.dex */
    public class d extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f54007a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f54008b;

        public d(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            this.f54007a = personalChatMessage;
            this.f54008b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.i0.d1.h.m.t().m(d.b.i0.d1.w.c.m(this.f54007a), this.f54008b, false));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.h0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f54009a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f54010b;

        public e(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            this.f54009a = personalChatMessage;
            this.f54010b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f54009a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f54009a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f54009a.getToUserId()), 2, this.f54010b, 3)));
        }
    }

    /* loaded from: classes3.dex */
    public class f extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f54011a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f54012b;

        public f(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            this.f54011a = officialChatMessage;
            this.f54012b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.i0.d1.h.l.t().m(d.b.i0.d1.w.c.m(this.f54011a), this.f54012b, false));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.h0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f54013a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f54014b;

        public g(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            this.f54013a = officialChatMessage;
            this.f54014b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            this.f54013a.setLogTime(System.currentTimeMillis());
            MessageManager.getInstance().sendMessage(this.f54013a);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f54013a.getToUserId()), 4, this.f54014b, 3)));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements VoiceSendModel.b {

        /* renamed from: d.b.i0.d1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1212a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f54016a;

            public C1212a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f54016a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.d1.h.c.h().o(this.f54016a.getGroupId(), String.valueOf(this.f54016a.getRecordId()), String.valueOf(this.f54016a.getMsgId()), 2));
            }
        }

        /* loaded from: classes3.dex */
        public class b implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f54017a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                this.f54017a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54017a);
            }
        }

        /* loaded from: classes3.dex */
        public class c extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f54018a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                this.f54018a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.d1.h.m.t().s(this.f54018a.getUserId(), this.f54018a.getToUserId(), String.valueOf(this.f54018a.getRecordId()), String.valueOf(this.f54018a.getMsgId()), 2));
            }
        }

        /* loaded from: classes3.dex */
        public class d implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f54019a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                this.f54019a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54019a);
            }
        }

        /* loaded from: classes3.dex */
        public class e extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54020a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                this.f54020a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.b.i0.d1.h.l.t().s(this.f54020a.getUserId(), this.f54020a.getToUserId(), String.valueOf(this.f54020a.getRecordId()), String.valueOf(this.f54020a.getMsgId()), 2));
            }
        }

        /* loaded from: classes3.dex */
        public class f implements d.b.h0.z0.n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f54021a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                this.f54021a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                a.m(this.f54021a);
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
                        VoiceMsgData n = d.b.i0.d1.w.c.n(chatMessage);
                        if (n != null) {
                            n.setVoice_md5(str);
                            String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                            chatMessage.setContent("[" + jsonStrWithObject + "]");
                        }
                        d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                        a.j().t(chatMessage);
                        if (a.this.f53992d != null) {
                            a.this.f53992d.a(2);
                            return;
                        }
                        return;
                    }
                    d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        h0.c(new C1212a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
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

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54022a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54023b;

        public i(String str, String str2) {
            this.f54022a = str;
            this.f54023b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            return BitmapFactory.decodeFile(this.f54022a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            a.this.r(this.f54023b, new d.b.b.j.d.a(bitmap, false));
        }
    }

    /* loaded from: classes3.dex */
    public class j extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54025a;

        public j(a aVar, String str) {
            this.f54025a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.i0.d1.h.c.h().f(this.f54025a, 2, null, 1000);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements d.b.h0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.s.c f54026a;

        public k(a aVar, d.b.i0.d1.s.c cVar) {
            this.f54026a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
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
                    String f2 = d.b.i0.d1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.i0.d1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f54026a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes3.dex */
    public class l extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54027a;

        public l(a aVar, String str) {
            this.f54027a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.i0.d1.h.m.t().f(this.f54027a, 2, null, 1000);
        }
    }

    /* loaded from: classes3.dex */
    public class m implements d.b.h0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.s.c f54028a;

        public m(a aVar, d.b.i0.d1.s.c cVar) {
            this.f54028a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
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
                    String f2 = d.b.i0.d1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.i0.d1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f54028a.a(linkedHashMap2, hashMap);
        }
    }

    /* loaded from: classes3.dex */
    public class n extends f0<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54029a;

        public n(a aVar, String str) {
            this.f54029a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            return d.b.i0.d1.h.l.t().f(this.f54029a, 2, null, 1000);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements d.b.h0.z0.n<LinkedHashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.s.c f54030a;

        public o(a aVar, d.b.i0.d1.s.c cVar) {
            this.f54030a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
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
                    String f2 = d.b.i0.d1.w.c.f(str3, true);
                    if (f2 != null) {
                        linkedHashMap2.put(str2, f2);
                    }
                    String f3 = d.b.i0.d1.w.c.f(str3, false);
                    if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = f3;
                        imageUrlData.urlType = 10;
                        hashMap.put(f2, imageUrlData);
                    }
                }
            }
            this.f54030a.a(linkedHashMap2, hashMap);
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
        if (f53988h == null) {
            synchronized (a.class) {
                if (f53988h == null) {
                    f53988h = new a();
                }
            }
        }
        return f53988h;
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
        i = Long.valueOf(j2);
    }

    public boolean g(ChatMessage chatMessage) {
        HashMap<String, d.b.h0.b0.a<ChatMessage>> hashMap = this.f53990b;
        if (hashMap != null && chatMessage != null) {
            for (Map.Entry<String, d.b.h0.b0.a<ChatMessage>> entry : hashMap.entrySet()) {
                d.b.h0.b0.a<ChatMessage> value = entry.getValue();
                if (value != null && value.f() != null) {
                    ChatMessage f2 = value.f();
                    if (chatMessage.getRecordId() != f2.getRecordId()) {
                        continue;
                    } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                            WeakReference<a.b<ChatMessage>> weakReference = this.f53994f;
                            if (weakReference != null && weakReference.get() != null) {
                                value.m(this.f53994f.get());
                            }
                            return true;
                        }
                    } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                        WeakReference<a.b<ChatMessage>> weakReference2 = this.f53994f;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            value.m(this.f53994f.get());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean h(ChatMessage chatMessage) {
        return i(chatMessage, this.f53989a) != -1;
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
        this.f53993e = voiceSendModel;
        voiceSendModel.t(this.f53995g);
        this.f53991c = new C1210a();
    }

    public final void l(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return;
        }
        this.f53989a.add(chatMessage);
    }

    public void n(String str, d.b.i0.d1.s.c cVar) {
        h0.c(new j(this, str), new k(this, cVar));
    }

    public void o(String str, d.b.i0.d1.s.c cVar) {
        h0.c(new n(this, str), new o(this, cVar));
    }

    public void p(String str, d.b.i0.d1.s.c cVar) {
        h0.c(new l(this, str), new m(this, cVar));
    }

    public final void q(ChatMessage chatMessage) {
        int i2 = i(chatMessage, this.f53989a);
        if (i2 >= 0) {
            this.f53989a.remove(i2);
        }
    }

    public final void r(String str, d.b.b.j.d.a aVar) {
        d.b.h0.a0.c.j().d(str, aVar);
        d.b.b.e.a.f.c cVar = new d.b.b.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(aVar.n());
        cVar.setGif(false);
        d.b.b.e.a.d.g().a(cVar);
    }

    public final void s(String str, String str2) {
        d.b.b.j.d.a l2 = d.b.h0.a0.c.j().l(str);
        String str3 = str2 + 10;
        if (l2 != null && l2.w()) {
            r(str3, l2);
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
        this.f53994f = new WeakReference<>(bVar);
    }

    public void v(d.b.i0.d1.s.d dVar) {
        this.f53992d = dVar;
    }

    public void y(ChatMessage chatMessage, String str) {
        d.b.h0.b0.a<ChatMessage> aVar = this.f53990b.get(str);
        if (aVar == null) {
            aVar = new d.b.h0.b0.a<>(str, "IM");
            aVar.j();
            aVar.i(chatMessage);
            WeakReference<a.b<ChatMessage>> weakReference = this.f53994f;
            if (weakReference != null && weakReference.get() != null) {
                aVar.m(this.f53994f.get());
            }
            aVar.l(this.f53991c);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar.h(String.valueOf(i));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar.h(String.valueOf(j));
            }
            synchronized (a.class) {
                this.f53990b.put(str, aVar);
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
        this.f53993e.u(voiceMsgData.getVoice_md5(), chatMessage);
    }
}
