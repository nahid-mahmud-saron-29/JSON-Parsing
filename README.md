# JSON Parsing with Volley & Glide 📱

এটি একটি সিম্পল অ্যান্ড্রয়েড অ্যাপ্লিকেশন, যা একটি লোকাল বা রিমোট সার্ভার থেকে **JSON (JSONArray)** ডেটা ফেচ (Fetch) করে এবং সেটি অ্যাপের ইউজার ইন্টারফেসে প্রদর্শন করে। নেটওয়ার্ক রিকোয়েস্টের জন্য এতে **Volley** এবং ইমেজ লোড করার জন্য **Glide** লাইব্রেরি ব্যবহার করা হয়েছে।

## 🚀 বৈশিষ্ট্যসমূহ (Features)
* **Custom JSON Parsing:** `JSONArray` এবং `JSONObject` ব্যবহার করে নিখুঁতভাবে ডেটা পার্সিং।
* **Volley Library:** দ্রুত ও সহজে নেটওয়ার্ক থেকে রেসপন্স হ্যান্ডেল করার সুবিধা।
* **Glide Integration:** ইউআরএল (URL) থেকে ইমেজ ক্যাশিং এবং স্মুথলি লোড করা।
* **Crash-Proof Error Handling:** ভুল বা খালি JSON রেসপন্সের কারণে অ্যাপ ক্র্যাশ হওয়া রোধে উন্নত ট্রাই-ক্যাচ (`try-catch`) লজিক।
* **UI Progress Indicator:** ডেটা লোড হওয়ার সময় ইউজারকে প্রোগ্রেস বার (Loader) দেখানো।

---

## 🛠️ টেকনোলজি স্ট্যাক (Tech Stack)
* **Language:** Java
* **UI Layout:** XML (LinearLayout)
* **Minimum SDK:** Android 5.0 (API Level 21) or higher
* **Libraries:**
  * [Volley](https://github.com/google/volley) - নেটওয়ার্কিং-এর জন্য।
  * [Glide](https://github.com/bumptech/glide) - ইমেজ লোডিং-এর জন্য।

---

## 📦 ডিপেনডেন্সি সমূহ (Dependencies)
আপনার প্রোজেক্টের `build.gradle (Module: app)` ফাইলের `dependencies` ব্লকে নিচের লাইব্রেরিগুলো যুক্ত করা আছে:

```groovy
dependencies {
    // Volley for Network Requests
    implementation 'com.android.volley:volley:1.2.1'
    
    // Glide for Image Loading
    implementation 'com.github.bumptech.glide:glide:4.16.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.16.0'
}
