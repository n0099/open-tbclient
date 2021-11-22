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

    /* renamed from: a  reason: collision with root package name */
    public int f68544a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68545b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f68546c;

    /* renamed from: d  reason: collision with root package name */
    public b f68547d;

    /* renamed from: e  reason: collision with root package name */
    public String f68548e;

    public g(Parcel parcel) {
        this.f68544a = parcel.readInt();
        this.f68545b = parcel.readByte() != 0;
        this.f68546c = parcel.createStringArrayList();
        this.f68547d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f68548e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f68548e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f68544a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f68545b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f68546c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f68546c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            b.j.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f68547d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f68544a;
    }

    public boolean b() {
        return this.f68545b;
    }

    public List<String> c() {
        return this.f68546c;
    }

    public b d() {
        return this.f68547d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f68544a + ", wifiUpload=" + this.f68545b + ", fileList=" + this.f68546c + ", controlMessage=" + this.f68547d + ", uploadMessage='" + this.f68548e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f68544a);
        parcel.writeByte(this.f68545b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f68546c);
        parcel.writeParcelable(this.f68547d, i2);
        parcel.writeString(this.f68548e);
    }
}
