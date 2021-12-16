package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i2) {
            return new g[i2];
        }
    };
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61104b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f61105c;

    /* renamed from: d  reason: collision with root package name */
    public b f61106d;

    /* renamed from: e  reason: collision with root package name */
    public String f61107e;

    public g(Parcel parcel) {
        this.a = parcel.readInt();
        this.f61104b = parcel.readByte() != 0;
        this.f61105c = parcel.createStringArrayList();
        this.f61106d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f61107e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f61107e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f61104b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f61105c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f61105c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            c.k.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f61106d = new b(str2, str3, str4);
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.f61104b;
    }

    public List<String> c() {
        return this.f61105c;
    }

    public b d() {
        return this.f61106d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.a + ", wifiUpload=" + this.f61104b + ", fileList=" + this.f61105c + ", controlMessage=" + this.f61106d + ", uploadMessage='" + this.f61107e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.f61104b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f61105c);
        parcel.writeParcelable(this.f61106d, i2);
        parcel.writeString(this.f61107e);
    }
}
