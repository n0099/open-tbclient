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
/* loaded from: classes2.dex */
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
    public boolean f60523b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f60524c;

    /* renamed from: d  reason: collision with root package name */
    public b f60525d;

    /* renamed from: e  reason: collision with root package name */
    public String f60526e;

    public g(Parcel parcel) {
        this.a = parcel.readInt();
        this.f60523b = parcel.readByte() != 0;
        this.f60524c = parcel.createStringArrayList();
        this.f60525d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f60526e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f60526e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f60523b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f60524c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f60524c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            c.k.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f60525d = new b(str2, str3, str4);
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.f60523b;
    }

    public List<String> c() {
        return this.f60524c;
    }

    public b d() {
        return this.f60525d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.a + ", wifiUpload=" + this.f60523b + ", fileList=" + this.f60524c + ", controlMessage=" + this.f60525d + ", uploadMessage='" + this.f60526e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.f60523b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f60524c);
        parcel.writeParcelable(this.f60525d, i2);
        parcel.writeString(this.f60526e);
    }
}
